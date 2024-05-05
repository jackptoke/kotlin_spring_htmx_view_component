package au.com.amesystems.kotlinspringhtmxviewcomponentstarter.core.repos

import au.com.amesystems.kotlinspringhtmxviewcomponentstarter.core.data.BatchOrder
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface BatchOrderRepo : JpaRepository<BatchOrder, Long> {
    @Query("select * from batch_orders o where o.reference = :reference", nativeQuery = true)
    fun findByReference(reference: String): List<BatchOrder>
    @Query("select * from batch_orders where plan_id is null", nativeQuery = true)
    fun findAllUnassignedOrders(): List<BatchOrder>
    @Query("select * from batch_orders where plan_id = :planId", nativeQuery = true)
    fun findAllOrdersByPlanId(planId: Long): List<BatchOrder>
}