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
}