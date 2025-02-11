package entity

import jakarta.persistence.*


@Entity
@Table(name = "device")
class Device {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null

    var description: String? = null
}