package au.com.amesystems.kotlinspringhtmxviewcomponentstarter.core.service

import au.com.amesystems.kotlinspringhtmxviewcomponentstarter.core.data.BatchOrder
import au.com.amesystems.kotlinspringhtmxviewcomponentstarter.core.repos.BatchOrderRepo
import org.springframework.stereotype.Service
import java.util.*

@Service
class BatchOrderService(val db: BatchOrderRepo) {
    fun findAll(): List<BatchOrder> = db.findAll()
    fun findBatchOrderById(id: Long) : Optional<BatchOrder> = db.findById(id)
    fun findBatchOrdersByReference(reference: String) : List<BatchOrder> = db.findByReference(reference)
    fun findUnassignedBatchOrders() : List<BatchOrder> = db.findAllUnassignedOrders()
    fun save(batchOrder: BatchOrder): BatchOrder = db.save(batchOrder)
    fun update(id: Long, batchOrder: BatchOrder): BatchOrder {
        var result = db.findById(id)
        if(result.isPresent) {
            val order = result.get()
            order.reference = batchOrder.reference
            order.harness = batchOrder.harness
            order.revision = batchOrder.revision
            order.quantity = batchOrder.quantity
            order.plDone = batchOrder.plDone
            order.customer = batchOrder.customer
            order.specialCode = batchOrder.specialCode
            order.workSite = batchOrder.workSite
            order.deliverySite = batchOrder.deliverySite
            order.deliveryLocation = batchOrder.deliveryLocation
            order.createdBy = batchOrder.createdBy
            order.createdDateTime = batchOrder.createdDateTime
            order.modifiedDateTime = batchOrder.modifiedDateTime
            order.modifiedBy = batchOrder.modifiedBy
            order.dispatchedDateTime = batchOrder.dispatchedDateTime
            order.releaseDueDate = batchOrder.releaseDueDate
            order.releasedDateTime = batchOrder.releasedDateTime
            order.releaseLocation = batchOrder.releaseLocation
            order.workPlan = batchOrder.workPlan
            db.save(order)
            return order
        }
        return batchOrder
    }
    fun deleteId(id: Long) = db.deleteById(id)

    fun deleteAll() = db.deleteAll()
}