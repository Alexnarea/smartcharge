package repository

import entity.Role
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
interface RoleRepository: JpaRepository<Role, Long> {
    fun findByUserIdAndRole (userId: Long?, role:String?): Role?
    fun findByUserId (userId: Long?): List<Role>
    @Modifying
    @Transactional
    @Query("DELETE FROM Role r WHERE r.user.id = :userId")
    fun deleteByUserId(userId: Long?)
}