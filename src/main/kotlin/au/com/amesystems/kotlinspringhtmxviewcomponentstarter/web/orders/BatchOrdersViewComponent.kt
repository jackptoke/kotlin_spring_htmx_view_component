package au.com.amesystems.kotlinspringhtmxviewcomponentstarter.web.orders

import au.com.amesystems.kotlinspringhtmxviewcomponentstarter.core.data.BatchOrder
import au.com.amesystems.kotlinspringhtmxviewcomponentstarter.core.service.BatchOrderService
import au.com.amesystems.kotlinspringhtmxviewcomponentstarter.web.index.IndexViewComponent
import de.tschuehly.spring.viewcomponent.core.component.ViewComponent
import de.tschuehly.spring.viewcomponent.thymeleaf.ActionViewContext

@ViewComponent
class BatchOrdersViewComponent(
    val batchOrderService: BatchOrderService
) {
    var batchOrders: MutableList<Long> = ArrayList()

    data class BatchOrdersView(val orders: List<BatchOrder>) : ActionViewContext

    fun render() = BatchOrdersView(batchOrderService.findUnassignedBatchOrders())

}