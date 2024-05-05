package au.com.amesystems.kotlinspringhtmxviewcomponentstarter.core.service

import au.com.amesystems.kotlinspringhtmxviewcomponentstarter.core.data.Machine
import au.com.amesystems.kotlinspringhtmxviewcomponentstarter.core.repos.MachineRepo
import org.springframework.stereotype.Service
import kotlin.jvm.optionals.toList

@Service
class MachineService(val db: MachineRepo) {

    fun getServiceName(): String {
        return "Machine Service"
    }

    fun findMachines(): List<Machine> = db.findAll()
    fun findMachineById(id: Long): List<Machine> {
        return db.findById(id).toList()
    }
    fun save(machine: Machine): Machine {
        db.save(machine)
        return machine
    }

    fun delete(id: Long) {
        db.deleteById(id)
    }

    fun deleteAll() {
        db.deleteAll()
    }

}