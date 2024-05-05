package au.com.amesystems.kotlinspringhtmxviewcomponentstarter.core.data

import jakarta.persistence.*

@Entity
@Table(name = "production_statuses")
@NoArg
class ProductionStatus(
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long,
    val status: String
    ) {

}