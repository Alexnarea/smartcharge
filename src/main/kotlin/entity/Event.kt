package entity

import jakarta.persistence.*
import java.time.LocalTime

@Entity
@Table(name = "events")
class Event {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null

    var battery: Int? = null

    var time: LocalTime? = null

    @ManyToOne
    @JoinColumn(name = "person_id")
    var person: Person? = null

    @ManyToOne
    @JoinColumn(name = "device_id")
    var device: Device? = null
}