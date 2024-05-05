package au.com.amesystems.kotlinspringhtmxviewcomponentstarter.core.data

import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name = "machines")
@NoArg
class Machine(
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long?,
    val name: String = "",
    val description: String = "",
    val brand: String = "",
    val model: String = "",
    val dataPath: String = "",
    val feedbackPath: String = "",
    val isActive: Boolean = false,
    val createdDate: LocalDate = LocalDate.now(),
    val createdBy: String = "",
    val modifiedDate: LocalDate = LocalDate.now(),
    val modifiedBy: String="",
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    val user: AmeUser?
    ) {
}