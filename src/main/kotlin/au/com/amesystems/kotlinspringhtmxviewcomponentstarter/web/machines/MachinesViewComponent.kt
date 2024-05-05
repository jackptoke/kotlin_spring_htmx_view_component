package au.com.amesystems.kotlinspringhtmxviewcomponentstarter.web.machines

import au.com.amesystems.kotlinspringhtmxviewcomponentstarter.core.data.Machine
import au.com.amesystems.kotlinspringhtmxviewcomponentstarter.core.service.AmeUserService
import au.com.amesystems.kotlinspringhtmxviewcomponentstarter.core.service.LoggingService
import au.com.amesystems.kotlinspringhtmxviewcomponentstarter.core.service.MachineService
import de.tschuehly.spring.viewcomponent.core.IViewContext
import de.tschuehly.spring.viewcomponent.core.action.DeleteViewAction
import de.tschuehly.spring.viewcomponent.core.action.GetViewAction
import de.tschuehly.spring.viewcomponent.core.action.PostViewAction
import de.tschuehly.spring.viewcomponent.core.component.ViewComponent
import de.tschuehly.spring.viewcomponent.thymeleaf.ActionViewContext
import de.tschuehly.spring.viewcomponent.thymeleaf.ViewContext


@ViewComponent
class MachinesViewComponent(val machineService: MachineService,
                            val userService: AmeUserService,
                            val logger: LoggingService)  {

    var machine = Machine(id = null, user = null)

    data class MachinesView(val title: String, val machines: List<Machine>, val machine: Machine) : ActionViewContext

    fun render() = MachinesView(machineService.getServiceName(), machineService.findMachines(), machine)

    class MachineDTO(
        val name: String,
        val description: String,
        val brand: String = "",
        val model: String = "",
        val dataPath: String = "",
        val feedbackPath: String = ""
    )

    @GetViewAction("/incrementScore")
    fun incrementScore() : ViewContext {
        return render()
    }

    @GetViewAction("/newMachine")
    fun newMachine() : ViewContext {
        this.machine = Machine(id = null, user = null)
        return render()
    }

    @PostViewAction
    fun saveMachine(machineData: MachineDTO): IViewContext {
        logger.log("Local: ${this.machine.name}")
        logger.log("Parameter: ${machineData.name}")
        val response = userService.findByUsername("jackptoke")

        if(response.isPresent) {
            val user = response.get()
            logger.log("User: ${user.username}")
            machineService.save(
                Machine(
                    id = null,
                    name = machineData.name,
                    description = machineData.description,
                    brand = machineData.brand,
                    model = machineData.model,
                    dataPath = machineData.dataPath,
                    feedbackPath = machineData.feedbackPath,
                    createdBy = user.username,
                    modifiedBy = user.username,
                    isActive = true,
                    user = user
                )
            )
        }
        return render()
    }

    @DeleteViewAction
    fun deleteMachine(id: Long) : IViewContext {
        machineService.delete(id)
        return render()
    }

}