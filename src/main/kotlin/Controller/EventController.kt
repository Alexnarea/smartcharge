package Controller

import Dto.EventDto
import entity.Event
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import response.SuccessResponse
import service.EventService


@RestController
@RequestMapping("api/events")
class EventController {
    @Autowired
    lateinit var eventService: EventService

    @GetMapping
    fun findAll(): ResponseEntity<*> {
        val response = eventService.findAll()
        return ResponseEntity(SuccessResponse(data = response), HttpStatus.OK)
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<*> {
        val response = eventService.findById(id)
        return ResponseEntity(SuccessResponse(data = response), HttpStatus.OK)
    }

    @PostMapping
    fun save (@RequestBody @Valid eventDto: EventDto): ResponseEntity<Any> {
        val response = eventService.save(eventDto)
        return ResponseEntity(SuccessResponse(data = response), HttpStatus.CREATED)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody @Valid eventDto: EventDto): ResponseEntity<Any> {
        val response = eventService.update(id, eventDto)
        return ResponseEntity(SuccessResponse(data = response), HttpStatus.OK)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Any> {
        val response = eventService.delete(id)
        return ResponseEntity(SuccessResponse(data = response), HttpStatus.OK)
    }
}