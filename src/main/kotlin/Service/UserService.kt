package Service

import jakarta.persistence.Column

@Entity
@Table(name = "users")
class UserService {
    @Id
    @Column (unique = true);
    var
}