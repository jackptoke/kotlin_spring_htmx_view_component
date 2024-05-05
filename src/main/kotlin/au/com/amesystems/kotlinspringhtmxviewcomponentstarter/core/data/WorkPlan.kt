package au.com.amesystems.kotlinspringhtmxviewcomponentstarter.core.data

import jakarta.persistence.*
import java.time.LocalDate
import java.time.LocalDateTime

@Entity
@Table(name = "work_plans")
@NoArg
class WorkPlan(
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long,
    val description: String,
    val startDate: LocalDate,
    val runDateTime: LocalDateTime,
    val priority: PlanPriority = PlanPriority.NORMAL,
    val transferStatus: TransferStatus = TransferStatus.NEW,
    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    val productionStatus: ProductionStatus,
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "workPlan", cascade = [CascadeType.ALL])
    val orders: Set<BatchOrder> = hashSetOf(),
    ) {

}