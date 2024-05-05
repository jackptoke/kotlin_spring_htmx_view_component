package au.com.amesystems.kotlinspringhtmxviewcomponentstarter.controller

import au.com.amesystems.kotlinspringhtmxviewcomponentstarter.core.service.BatchOrderService
import au.com.amesystems.kotlinspringhtmxviewcomponentstarter.web.orders.BatchOrdersViewComponent
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/batch-orders")
class BatchOrderController(private val batchOrdersViewComponent: BatchOrdersViewComponent) {
    @GetMapping
    fun index() = batchOrdersViewComponent.render()
}