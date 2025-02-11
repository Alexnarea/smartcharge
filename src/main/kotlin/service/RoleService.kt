package service

import Dto.RoleDto
import Mapper.RoleMapper
import entity.Role
import jakarta.persistence.EntityNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import repository.RoleRepository

@Service
class RoleService {
    @Autowired
    lateinit var roleRepository: RoleRepository

    @Autowired
    lateinit var roleMapper: RoleMapper

    fun findAll(): List<RoleDto> {
        val role = roleRepository.findAll()
        return role.map {roleMapper.toRoleDto(it)}
    }

    fun findById(id: Long): RoleDto {
        val role = roleRepository.findById(id)
            .orElseThrow{EntityNotFoundException("Role with id $id not found")}
        return roleMapper.toRoleDto(role)
    }

    fun save(roleDto: RoleDto): RoleDto {
        val role = roleMapper.toEntity(roleDto)
        val saveRole = roleRepository.save(role)
        return roleMapper.toRoleDto(saveRole)
    }

    fun update(id: Long, roleDto: RoleDto): RoleDto {
        val role = roleRepository.findById(id)
        .orElseThrow{EntityNotFoundException("Role with id $id not found")}
        role.apply{
            roleName = roleDto.roleName
        }
        val updateRole = roleRepository.save(role)
        return roleMapper.toRoleDto(updateRole)
    }

    fun delete(id: Long) {
        val role = roleRepository.findById(id)
        .orElseThrow{EntityNotFoundException("Role with id $id not found")}
        roleRepository.delete(role)
    }
}