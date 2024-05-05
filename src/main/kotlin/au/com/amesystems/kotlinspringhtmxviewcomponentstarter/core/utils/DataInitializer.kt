package au.com.amesystems.kotlinspringhtmxviewcomponentstarter.core.utils

import kotlinx.coroutines.runBlocking
import au.com.amesystems.kotlinspringhtmxviewcomponentstarter.core.data.AmeUser
import au.com.amesystems.kotlinspringhtmxviewcomponentstarter.core.data.Machine
import au.com.amesystems.kotlinspringhtmxviewcomponentstarter.core.service.AmeUserService
import au.com.amesystems.kotlinspringhtmxviewcomponentstarter.core.service.MachineService
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component

@Component
class DataInitializer(val machineService: MachineService, val ameUser: AmeUserService) {

    @EventListener(value = [ApplicationReadyEvent::class])
    fun initialize() = runBlocking {
        machineService.deleteAll()
        ameUser.deleteAll()

        val newUser = ameUser.save(AmeUser(id =null, username = "jackptoke", email = "jackptoke@gmail.com", password = "password", isActive = false))
        val newMachine = machineService.save(
            Machine(
                id=null,
                name = "Machine1",
                description = "IT Dev Machine",
                brand="Komax",
                model = "K350",
                dataPath = "\\\\wpcs\\data",
                feedbackPath = "\\\\wpcd\\feedback",
                isActive = true,
                user = newUser,
                createdBy = "jackptoke",
                modifiedBy = "jackptoke",
            ))
        }
}