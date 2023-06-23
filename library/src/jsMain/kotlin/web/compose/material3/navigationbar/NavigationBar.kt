package web.compose.material3.navigationbar

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import web.compose.material3.MdElement
import web.compose.material3.MdTagElement
import web.compose.material3.jsRequire

abstract class NavigationBarElement : MdElement()

@Composable
fun NavigationBar(
    attrs: AttrBuilderContext<NavigationBarElement>? = null,
    content: ContentBuilder<NavigationBarElement>? = null
) = MdTagElement(
    tagName = "md-navigation-bar",
    applyAttrs = attrs,
    content = content
).also {
    webComponentLoader
}

private val webComponentLoader = jsRequire("@material/web/labs/navigationbar/navigation-bar.js")
