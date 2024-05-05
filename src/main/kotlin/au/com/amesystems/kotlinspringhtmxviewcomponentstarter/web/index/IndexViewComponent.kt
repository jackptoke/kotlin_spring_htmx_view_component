package au.com.amesystems.kotlinspringhtmxviewcomponentstarter.web.index

import de.tschuehly.spring.viewcomponent.core.IViewContext
import de.tschuehly.spring.viewcomponent.core.component.ViewComponent
import de.tschuehly.spring.viewcomponent.thymeleaf.ViewContext

@ViewComponent
class IndexViewComponent {
    data class IndexView(val nestedViewComponent: IViewContext) : IViewContext
    fun render(nestedViewComponent : IViewContext) = IndexView(nestedViewComponent)
}