package au.com.amesystems.kotlinspringhtmxviewcomponentstarter.controller

import au.com.amesystems.kotlinspringhtmxviewcomponentstarter.web.machines.MachinesViewComponent
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/machines")
class MachineController(private val machinesViewComponent: MachinesViewComponent) {
    @GetMapping
    fun index() = machinesViewComponent.render()


}