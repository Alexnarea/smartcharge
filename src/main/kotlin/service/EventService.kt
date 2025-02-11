package service

import Dto.EventDto
import Mapper.EventMapper
import entity.Event
import jakarta.persistence.EntityNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import repository.EventRepository
import java.time.LocalTime

@Service
class EventService {
    @Autowired
    lateinit var eventRepository: EventRepository

    @Autowired
    lateinit var eventMapper: EventMapper

    fun findAll(): List<EventDto> {
        val event = eventRepository.findAll()
        return event.map {eventMapper.toEventDto(it)}
    }

    fun findById(id: Long): EventDto {
        val event = eventRepository.findById(id)
            .orElseThrow{EntityNotFoundException("Event with id $id not found")}
        return eventMapper.toEventDto(event)
    }

    fun save(eventDto: EventDto): EventDto {
        val event = eventMapper.toEntity(eventDto)
        val saveEvent = eventRepository.save(event)
        return eventMapper.toEventDto(saveEvent)
    }


    fun update(id: Long, eventDto: EventDto): EventDto {
        val event = eventRepository.findById(id)
        .orElseThrow{EntityNotFoundException("Event with id $id not found")}
        event.apply {
            battery = eventDto.baterry
            time = eventDto.time
        }
        val updateEvent = eventRepository.save(event)
        return eventMapper.toEventDto(updateEvent)
    }

    fun delete(id: Long) {
        val event = eventRepository.findById(id)
        .orElseThrow{EntityNotFoundException("Event with id $id not found")}
        eventRepository.delete(event)
    }


}