package web.compose.material3.navigationdrawer

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.ElementBuilder
import org.jetbrains.compose.web.dom.TagElement
import web.compose.material3.ElementBuilderImplementation
import web.compose.material3.jsRequire

@Composable
fun ModalNavigationDrawer(
    attrs: AttrBuilderContext<NavigationDrawerElement>? = null,
    content: ContentBuilder<NavigationDrawerElement>? = null
) = TagElement(
    elementBuilder = ModalNavigationDrawerElementBuilder,
    applyAttrs = attrs,
    content = content
)

private val ModalNavigationDrawerElementBuilder: ElementBuilder<NavigationDrawerElement> =
    ElementBuilderImplementation<NavigationDrawerElement>("md-navigation-drawer-modal").also {
        jsRequire("@material/web/labs/navigationdrawer/navigation-drawer-modal.js")
    }
