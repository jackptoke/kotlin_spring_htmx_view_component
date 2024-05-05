package au.com.amesystems.kotlinspringhtmxviewcomponentstarter.web.users

import au.com.amesystems.kotlinspringhtmxviewcomponentstarter.core.data.AmeUser
import au.com.amesystems.kotlinspringhtmxviewcomponentstarter.core.service.AmeUserService
import au.com.amesystems.kotlinspringhtmxviewcomponentstarter.core.service.LoggingService
import de.tschuehly.spring.viewcomponent.core.IViewContext
import de.tschuehly.spring.viewcomponent.core.action.DeleteViewAction
import de.tschuehly.spring.viewcomponent.core.action.GetViewAction
import de.tschuehly.spring.viewcomponent.core.action.PostViewAction
import de.tschuehly.spring.viewcomponent.core.component.ViewComponent
import de.tschuehly.spring.viewcomponent.thymeleaf.ActionViewContext
import de.tschuehly.spring.viewcomponent.thymeleaf.ViewContext

@ViewComponent
class UsersViewComponent(val userService: AmeUserService,
                         val logger: LoggingService) {

    data class UsersView(val users: List<AmeUser>, val user: AmeUser, val errors: List<String>) : ActionViewContext
    var user: AmeUser = AmeUser(id = null, username = "", password = "", email = "", isActive = false)
    var errorMessages = mutableListOf<String>()
    fun render() = UsersView(userService.findAll(), user, errorMessages)

    class UserDTO(
        val id: Long?,
        val username: String,
        val email: String,
        val password: String,
    )

    @GetViewAction("/newUser")
    fun newUser() : ViewContext {
        this.user = AmeUser(id = null, username = "", email = "", password = "", isActive = true)
        return render()
    }

    @GetViewAction
    fun editUser(id: Long) : IViewContext {
        val result = userService.findById(id)
        if(result.isPresent) {
            this.user = result.get()
        }
        else{
            errorMessages.clear()
            errorMessages.add("User $id not found")
        }
        return render()
    }

    @PostViewAction
    fun saveUser(userData: UserDTO) : IViewContext {
        val response = userService.findByUsername(userData.username)
        if(!response.isPresent) {
            logger.log("Saving ${userData.username}")
            val newUser = AmeUser(
                id = null,
                username = userData.username,
                email = userData.email,
                password = userData.password,
                isActive = true)
            userService.save(newUser)
            user = AmeUser(id = null, username = "", email = "", password = "", isActive = true)
        }
        else{
            errorMessages.clear()
            errorMessages.add("User ${ userData.username} already exists")
        }
        return render()
    }

    @DeleteViewAction
    fun deleteUser(id: Long) : ViewContext {
        userService.delete(id)
        return render()
    }
}