package Dto

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull

class PersonDto {

    var id: Long? = null

    @NotNull(message = "fullname is required")
    @NotBlank(message = "fullname is required")
    var fullName: String? = null

    var age: Int? = null

    var telephone: String? = null

    var email: String? = null

    var username: String? = null

}