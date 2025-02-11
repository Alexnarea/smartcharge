package Mapper

import Dto.EventDto
import entity.Event
import org.springframework.stereotype.Component

@Component
object EventMapper {

    fun toEntity(eventDto: EventDto): Event {
        val event = Event()
        event.id = eventDto.id
        event.battery = eventDto.baterry
        event.time = eventDto.time
        return event
    }

    fun toEventDto(event: Event): EventDto {
        val eventDto = EventDto()
        eventDto.id = event.id
        eventDto.baterry = event.battery
        eventDto.time = event.time
        return eventDto
    }
}