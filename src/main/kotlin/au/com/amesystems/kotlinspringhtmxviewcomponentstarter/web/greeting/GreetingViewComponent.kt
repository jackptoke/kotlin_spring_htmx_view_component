package au.com.amesystems.kotlinspringhtmxviewcomponentstarter.web.greeting

import au.com.amesystems.kotlinspringhtmxviewcomponentstarter.core.service.GreetingService
import de.tschuehly.spring.viewcomponent.core.action.GetViewAction
import de.tschuehly.spring.viewcomponent.core.component.ViewComponent
import de.tschuehly.spring.viewcomponent.thymeleaf.ViewContext

@ViewComponent
class GreetingViewComponent(val greetingService: GreetingService) {

    data class GreetingView(val message: String, val likes: Int) : ViewContext

    var likes: Int = 0

    fun render() = GreetingView(greetingService.getHelloWorld(), likes)

    @GetViewAction("/incrementLikes")
    fun incrementLikes(): ViewContext {
        likes += 1
        return render()
    }
}