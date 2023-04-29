package web.compose.material3.navigationbar

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.ElementBuilder
import org.jetbrains.compose.web.dom.TagElement
import web.compose.material3.ElementBuilderImplementation
import web.compose.material3.MdElement

abstract class NavigationBarElement : MdElement()

@Composable
fun NavigationBar(
    attrs: AttrBuilderContext<NavigationBarElement>? = null,
    content: ContentBuilder<NavigationBarElement>? = null
) = TagElement(
    elementBuilder = NavigationBarElementBuilder,
    applyAttrs = attrs,
    content = content
)

private val NavigationBarElementBuilder: ElementBuilder<NavigationBarElement> =
    ElementBuilderImplementation("md-navigation-bar")
