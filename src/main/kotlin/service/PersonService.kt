package service

import Dto.PersonDto
import Mapper.PersonMapper
import repository.PersonRespository
import jakarta.persistence.EntityNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PersonService {

    @Autowired
    lateinit var personRespository: PersonRespository

    @Autowired
    lateinit var userMapper: PersonMapper


    fun findAll(): List<PersonDto> {
        val user = personRespository.findAll()
        return user.map { userMapper.toUserDto(it) }
    }

    fun findById(id: Long): PersonDto {
        val user = personRespository.findById(id)
            .orElseThrow { EntityNotFoundException("Testb with id $id not found") }
        return userMapper.toUserDto(user)
    }

    fun save(personDto: PersonDto): PersonDto {
        val user = userMapper.toEntity(personDto)
        val saveUser = personRespository.save(user)
        return userMapper.toUserDto(saveUser)
    }

    fun update(id: Long, personDto: PersonDto): PersonDto {
        val user = personRespository.findById(id)
        .orElseThrow { EntityNotFoundException("Test with id $id not found") }
        user.apply {
            fullName = personDto.fullName
            age = personDto.age
            telephone = personDto.telephone
            email = personDto.email
        }
        val updateUser = personRespository.save(user)
        return userMapper.toUserDto(updateUser)
    }

    fun delete(id: Long) {
        val user = personRespository.findById(id)
        .orElseThrow { EntityNotFoundException("Testb with id $id not found") }
        personRespository.delete(user)
    }
}