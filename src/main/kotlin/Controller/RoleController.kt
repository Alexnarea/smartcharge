package Controller

import Dto.RoleDto
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import response.SuccessResponse
import service.RoleService


@RestController
@RequestMapping("api/roles")
class RoleController {

    @Autowired
    lateinit var roleService: RoleService

    @GetMapping
    fun findAll(): ResponseEntity<*> {
        val response = roleService.findAll()
        return ResponseEntity(SuccessResponse(data = response), HttpStatus.OK)
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<*> {
        val response = roleService.findById(id)
        return ResponseEntity(SuccessResponse(data = response), HttpStatus.OK)
    }

    @PostMapping
    fun save(@RequestBody @Valid roleDto: RoleDto): ResponseEntity<Any> {
        val response = roleService.save(roleDto)
        return ResponseEntity(SuccessResponse(data = response), HttpStatus.CREATED)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody @Valid roleDto: RoleDto): ResponseEntity<Any> {
        val response = roleService.update(id, roleDto)
        return ResponseEntity(SuccessResponse(data = response), HttpStatus.OK)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Any> {
        val response = roleService.delete(id)
        return ResponseEntity(SuccessResponse(data = response), HttpStatus.OK)
    }
}