package au.com.amesystems.kotlinspringhtmxviewcomponentstarter.controller

import au.com.amesystems.kotlinspringhtmxviewcomponentstarter.web.users.UsersViewComponent
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/users")
class UserController(private val usersViewComponent: UsersViewComponent) {
    @GetMapping
    fun index() = usersViewComponent.render()
}