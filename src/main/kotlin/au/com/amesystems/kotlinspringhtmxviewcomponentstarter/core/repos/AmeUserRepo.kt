package au.com.amesystems.kotlinspringhtmxviewcomponentstarter.core.repos

import au.com.amesystems.kotlinspringhtmxviewcomponentstarter.core.data.AmeUser
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface AmeUserRepo : JpaRepository<AmeUser, Long> {
    @Query(value = "SELECT * FROM users u WHERE u.username = :username OR u.email = :username", nativeQuery = true)
    fun findByUsername(username: String): Optional<AmeUser>
}