package Controller

import Dto.DeviceDto
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import response.SuccessResponse
import service.DeviceService

@RestController
@RequestMapping("/api/devices")
class DeviceController {

    @Autowired
    lateinit var deviceService: DeviceService


    @GetMapping
    fun findAll(): ResponseEntity<*> {
        val response = deviceService.findAll()
        return ResponseEntity(SuccessResponse(data = response), HttpStatus.OK)
    }


    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<*> {
        val response = deviceService.findById(id)
        return ResponseEntity(SuccessResponse(data = response), HttpStatus.OK)
    }


    @PostMapping
    fun save(@RequestBody @Valid deviceDto: DeviceDto): ResponseEntity<Any> {
        val response = deviceService.save(deviceDto)
        return ResponseEntity(SuccessResponse(data = response), HttpStatus.CREATED)
    }


    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody @Valid deviceDto: DeviceDto): ResponseEntity<Any> {
        val response = deviceService.findById(id)
        return ResponseEntity(SuccessResponse(data = response), HttpStatus.OK)
    }


    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Any> {
        val response = deviceService.delete(id)
        return ResponseEntity(SuccessResponse(data = response), HttpStatus.OK)
    }
}