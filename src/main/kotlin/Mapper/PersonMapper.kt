package Mapper

import Dto.PersonDto
import entity.Person
import org.springframework.stereotype.Component

@Component
object PersonMapper {

    fun toEntity(personDto: PersonDto): Person {
        val person = Person()
        person.id = personDto.id
        person.fullName = personDto.fullName
        person.age = personDto.age
        person.telephone = personDto.telephone
        person.email = personDto.email
        return person
    }

    fun toUserDto(person: Person): PersonDto {
        val personDto = PersonDto()
        personDto.id = person.id
        personDto.fullName = person.fullName
        personDto.age = person.age
        personDto.telephone = person.telephone
        personDto.email = person.email
        return personDto
    }
}