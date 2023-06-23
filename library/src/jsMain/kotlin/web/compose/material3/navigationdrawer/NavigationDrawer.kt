package web.compose.material3.navigationdrawer

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import web.compose.material3.InvalidCallException
import web.compose.material3.MdElement
import web.compose.material3.MdTagElement
import web.compose.material3.jsRequire
import web.compose.material3.textfield.MdTextFieldElement

abstract class NavigationDrawerElement : MdElement()

@Composable
fun NavigationDrawer(
    attrs: AttrBuilderContext<NavigationDrawerElement>? = null,
    content: ContentBuilder<NavigationDrawerElement>? = null
) = MdTagElement(
    tagName = "md-navigation-drawer",
    applyAttrs = attrs,
    content = content
).also {
    webComponentLoader
}

private val webComponentLoader = jsRequire("@material/web/labs/navigationdrawer/navigation-drawer.js")

fun AttrsScope<NavigationDrawerElement>.opened(value: Boolean = true) {
    if (value) attr("opened", "")
}

var AttrsScope<MdTextFieldElement>.pivot: Pivot
    get() {
        throw InvalidCallException()
    }
    set(pivot) {
        this.attr("pivot", pivot.value)
    }


enum class Pivot(val value: String) {
    START("start"),
    END("end"),
}
