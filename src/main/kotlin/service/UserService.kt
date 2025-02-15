package service

import entity.Role
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import repository.UserRepository

@Service
class UserService {

    @Autowired
    private lateinit var passwordEncoder: PasswordEncoder

    @Autowired
    lateinit var userRepository: UserRepository

    @Autowired
    private val jwtUtil: JwtUtil? = null

    @Override
    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(username: String): UserDetails? {
        val userEntity = userRepository.findByUsername(username)
            ?: throw UsernameNotFoundException("Bad credentials")
        val authorityList: MutableList<SimpleGrantedAuthority> = ArrayList()

        userEntity.roles!!.forEach(Consumer<Role> { role: Role ->
            authorityList.add(
                SimpleGrantedAuthority("ROLE_${role.role}")
            )
        })

        return User.builder()
            .username(userEntity.username)
            .password(userEntity.password)
            .authorities(authorityList)
            .accountLocked(userEntity.locked!!)
            .disabled(userEntity.disabled!!)
            .build()
    }

    fun login(loginDto: LoginDto): TokenDto? {

        val authentication: Authentication = authenticate(loginDto.username!!, loginDto.password!!)
        SecurityContextHolder.getContext().authentication=authentication
        val accessToken = jwtUtil!!.create(authentication)
        return TokenDto().apply {
            jwt = accessToken
        }
    }

    fun authenticate(username: String, password: String): Authentication {
        try {

            val userDetails = loadUserByUsername(username)
                ?: throw UsernameNotFoundException("Bad credentials.")

            if (!passwordEncoder.matches(password, userDetails.password)) {
                throw UsernameNotFoundException("Bad credentials.")
            }

            return UsernamePasswordAuthenticationToken(username, password,userDetails.authorities)
        } catch (ex: Exception) {
            throw Exception()
        }

    }
}