package Mapper

import Dto.RoleDto
import entity.Role
import org.springframework.stereotype.Component

@Component
object RoleMapper {

    fun toEntity(roleDto: RoleDto): Role {
        val role = Role()
        role.id = roleDto.id
        role.roleName = roleDto.roleName
        return role
    }

    fun toRoleDto(role: Role): RoleDto {
        val roleDto = RoleDto()
        roleDto.id = role.id
        roleDto.roleName = role.roleName
        return roleDto
    }
}