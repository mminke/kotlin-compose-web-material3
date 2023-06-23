package web.compose.material3.navigationdrawer

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import web.compose.material3.MdTagElement
import web.compose.material3.jsRequire

@Composable
fun ModalNavigationDrawer(
    attrs: AttrBuilderContext<NavigationDrawerElement>? = null,
    content: ContentBuilder<NavigationDrawerElement>? = null
) = MdTagElement(
    tagName = "md-navigation-drawer-modal",
    applyAttrs = attrs,
    content = content
).also {
    webComponentLoader
}

private val webComponentLoader = jsRequire("@material/web/labs/navigationdrawer/navigation-drawer-modal.js")
