package Controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import service.UserService

@RestController
@RequestMapping("/auth")
class AuthController {
    @Autowired
    lateinit var userService: UserService

    @PostMapping("/login")
    fun login(@RequestBody loginDto: LoginDto): ResponseEntity<*>? {
        val response = userService.login(loginDto)
        return ResponseEntity<Any?>(response, HttpStatus.OK)
    }
}