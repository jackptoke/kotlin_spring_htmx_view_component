package au.com.amesystems.kotlinspringhtmxviewcomponentstarter.core.data

import jakarta.persistence.*
import java.time.LocalDate
import java.time.LocalDateTime

@Entity
@Table(name = "batch_orders")
@NoArg
class BatchOrder(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long,
    val reference: String,
    val harness: String,
    val revision: String = "",
    val quantity: Int = 1,
    val customer: String,
    val workSite: String,
    val deliverySite: String,
    val deliveryLocation: String,
    val releaseLocation: String,
    val specialCode: String="",
    val plDone: LocalDateTime,
    val releaseDueDate: LocalDate,
    val releasedDateTime: LocalDateTime,
    val dispatchedDateTime: LocalDateTime,
    val createdDateTime: LocalDateTime = LocalDateTime.now(),
    val modifiedDateTime: LocalDateTime = LocalDateTime.now(),
    val createdBy: String,
    val modifiedBy: String,
    @ManyToOne
    @JoinColumn(name = "plan_id", referencedColumnName = "id")
    val workPlan: WorkPlan?
) {
}