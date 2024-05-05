package au.com.amesystems.kotlinspringhtmxviewcomponentstarter.core.data

import jakarta.persistence.*

@Entity
@Table(name = "users")
@NoArg
class AmeUser(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long?,
    val username: String,
    val email: String,
    val password: String,
    val isActive: Boolean
    ) {
}