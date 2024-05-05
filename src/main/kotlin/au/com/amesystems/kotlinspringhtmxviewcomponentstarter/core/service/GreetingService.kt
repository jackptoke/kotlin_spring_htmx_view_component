package au.com.amesystems.kotlinspringhtmxviewcomponentstarter.core.service

import org.springframework.stereotype.Service

@Service
class GreetingService {
    val dataIndex = 0
    val itemList = mutableMapOf<Int, String>()

    fun getHelloWorld(): String {
        return "Hello, Jack"
    }
}