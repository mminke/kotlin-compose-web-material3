package web.compose.material3.navigationdrawer

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.ElementBuilder
import org.jetbrains.compose.web.dom.TagElement
import org.w3c.dom.Element
import web.compose.material3.ElementBuilderImplementation

abstract external class NavigationDrawerElement : Element

@Composable
fun NavigationDrawer(
    attrs: AttrBuilderContext<NavigationDrawerElement>? = null,
    content: ContentBuilder<NavigationDrawerElement>? = null
) = TagElement(
    elementBuilder = NavigationDrawerElementBuilder,
    applyAttrs = attrs,
    content = content
)

private val NavigationDrawerElementBuilder: ElementBuilder<NavigationDrawerElement> =
    ElementBuilderImplementation("md-navigation-drawer")
