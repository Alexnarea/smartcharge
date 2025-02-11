package Controller

import Dto.PersonDto
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import response.SuccessResponse
import service.PersonService


@RestController
@RequestMapping("api/users")
class PersonController {
    @Autowired
    lateinit var personService: PersonService

    @GetMapping
    fun findAll(): ResponseEntity<*>{
        val response = personService.findAll()
        return ResponseEntity(SuccessResponse(data = response), HttpStatus.OK)
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<*>{
        val response = personService.findById(id)
        return ResponseEntity(SuccessResponse(data = response), HttpStatus.OK)
    }

    @PostMapping
    fun save (@RequestBody @Valid personDto: PersonDto): ResponseEntity<Any>{
        val response = personService.save(personDto)
        return ResponseEntity(SuccessResponse(data = response), HttpStatus.CREATED)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody @Valid personDto: PersonDto): ResponseEntity<Any>{
        val response = personService.update(id, personDto)
        return ResponseEntity(SuccessResponse(data = response), HttpStatus.OK)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Any>{
        val response = personService.delete(id)
        return ResponseEntity(SuccessResponse(data = response), HttpStatus.OK)
    }
}