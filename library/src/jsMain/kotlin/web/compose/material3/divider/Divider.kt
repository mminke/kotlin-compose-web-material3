package web.compose.material3.divider

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.ElementBuilder
import org.jetbrains.compose.web.dom.TagElement
import web.compose.material3.ElementBuilderImplementation
import web.compose.material3.MdElement

@Composable
fun Divider(
    attrs: AttrBuilderContext<MdElement>? = null,
    content: ContentBuilder<MdElement>? = null
) = TagElement(
    elementBuilder = DividerElementBuilder,
    applyAttrs = attrs,
    content = content
)

private val DividerElementBuilder: ElementBuilder<MdElement> =
    ElementBuilderImplementation("md-divider")
