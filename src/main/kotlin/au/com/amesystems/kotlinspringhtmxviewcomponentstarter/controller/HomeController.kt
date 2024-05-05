package au.com.amesystems.kotlinspringhtmxviewcomponentstarter.controller

import au.com.amesystems.kotlinspringhtmxviewcomponentstarter.web.greeting.GreetingViewComponent
import au.com.amesystems.kotlinspringhtmxviewcomponentstarter.web.index.IndexViewComponent
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class HomeController(
    private val indexViewComponent: IndexViewComponent,
    private val greetingViewComponent: GreetingViewComponent
    ) {
    @GetMapping("/")
    fun indexComponent() = indexViewComponent.render(greetingViewComponent.render())

}