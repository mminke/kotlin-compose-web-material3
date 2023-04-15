package web.compose.material3.navigationbar

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.ElementBuilder
import org.jetbrains.compose.web.dom.TagElement
import org.w3c.dom.Element
import web.compose.material3.ElementBuilderImplementation


private val MdNavigationBarElementBuilder: ElementBuilder<MdNavigationBarElement> =
    ElementBuilderImplementation("md-navigation-bar")


abstract external class MdNavigationBarElement : Element

@Composable
fun MdNavigationBar(
    attrs: AttrBuilderContext<MdNavigationBarElement>? = null,
    content: ContentBuilder<MdNavigationBarElement>? = null
) = TagElement(
    elementBuilder = MdNavigationBarElementBuilder,
    applyAttrs = attrs,
    content = content
)
