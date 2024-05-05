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
    var reference: String,
    var harness: String,
    var revision: String = "",
    var quantity: Int = 1,
    var customer: String,
    var workSite: String,
    var deliverySite: String,
    var deliveryLocation: String,
    var releaseLocation: String,
    var specialCode: String="",
    var plDone: LocalDateTime,
    var releaseDueDate: LocalDate,
    var releasedDateTime: LocalDateTime,
    var dispatchedDateTime: LocalDateTime,
    var createdDateTime: LocalDateTime = LocalDateTime.now(),
    var modifiedDateTime: LocalDateTime = LocalDateTime.now(),
    var createdBy: String,
    var modifiedBy: String,
    @ManyToOne
    @JoinColumn(name = "plan_id", referencedColumnName = "id")
    var workPlan: WorkPlan?
) {
}