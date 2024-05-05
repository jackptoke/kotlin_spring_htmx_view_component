package au.com.amesystems.kotlinspringhtmxviewcomponentstarter.core.service

import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.stereotype.Service

@Service
class LoggingService {
    private val logger = KotlinLogging.logger {}
    fun log(message: String) {
        logger.info { message }
    }
}