package au.com.amesystems.kotlinspringhtmxviewcomponentstarter.core.data

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDate
import java.time.LocalDateTime

@Entity
@Table(name = "materials")
@NoArg
class MaterialComponent(
    name: String,
    description: String,
    createdDate: LocalDateTime = LocalDateTime.now(),
    modifiedDate: LocalDateTime = LocalDateTime.now(),
    createdBy: String,
    modifiedBy: String,
    unitOfMeasurement: UnitOfMeasurement,
    val weightPerUnit: Double,
    val weightUnit: UnitOfMeasurement
) : BaseComponent(null,
    name, description,
    createdDate, modifiedDate,
    createdBy, modifiedBy, unitOfMeasurement) {
}