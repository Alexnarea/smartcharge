package entity

import jakarta.persistence.*


@Entity
@Table(name = "person")
class Person {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null

    var fullName: String? = null
    var age: Int? = null
    var telephone: String? = null

    @Column(length = 50)
    var email: String? = null

    @OneToOne
    @JoinColumn(name = "users_id")
    var user: User? = null
}