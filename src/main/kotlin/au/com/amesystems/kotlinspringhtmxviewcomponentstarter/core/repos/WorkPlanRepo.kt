package au.com.amesystems.kotlinspringhtmxviewcomponentstarter.core.repos

import au.com.amesystems.kotlinspringhtmxviewcomponentstarter.core.data.WorkPlan
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface WorkPlanRepo : JpaRepository<WorkPlan, Long> {
}