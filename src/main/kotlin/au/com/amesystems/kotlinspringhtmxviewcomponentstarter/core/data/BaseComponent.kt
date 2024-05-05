package au.com.amesystems.kotlinspringhtmxviewcomponentstarter.core.data

import jakarta.persistence.*
import java.time.LocalDate
import java.time.LocalDateTime

@MappedSuperclass
@NoArg
open class BaseComponent(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long?,
    val name: String,
    val description: String,
    val createdDate: LocalDateTime,
    val modifiedDate: LocalDateTime,
    val createdBy: String,
    val modifiedBy: String,
    val unitOfMeasurement: UnitOfMeasurement = UnitOfMeasurement.EACH
) {
}