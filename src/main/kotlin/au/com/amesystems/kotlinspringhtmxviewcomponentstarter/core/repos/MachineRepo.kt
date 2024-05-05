package au.com.amesystems.kotlinspringhtmxviewcomponentstarter.core.repos

import au.com.amesystems.kotlinspringhtmxviewcomponentstarter.core.data.Machine
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MachineRepo : JpaRepository<Machine, Long> {
}