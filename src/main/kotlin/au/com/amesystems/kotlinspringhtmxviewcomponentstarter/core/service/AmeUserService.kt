package au.com.amesystems.kotlinspringhtmxviewcomponentstarter.core.service

import au.com.amesystems.kotlinspringhtmxviewcomponentstarter.core.data.AmeUser
import au.com.amesystems.kotlinspringhtmxviewcomponentstarter.core.repos.AmeUserRepo
import org.springframework.stereotype.Service
import java.util.Optional
import kotlin.jvm.optionals.toList

@Service
class AmeUserService(val db: AmeUserRepo) {
    fun findAll(): List<AmeUser> = db.findAll().toList()
    fun findById(id: Long): Optional<AmeUser> = db.findById(id)
    fun findByUsername(username: String): Optional<AmeUser> = db.findByUsername(username)
    fun save(user: AmeUser): AmeUser = db.save(user)
    fun delete(id: Long) = db.deleteById(id)
    fun deleteAll() {
        db.deleteAll()
    }

    fun<T : Any> Optional<out T>.toList(get: T): List<T> = if (isPresent) this.toList(get()) else emptyList()
}