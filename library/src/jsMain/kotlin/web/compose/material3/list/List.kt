package web.compose.material3.list

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.ElementBuilder
import org.jetbrains.compose.web.dom.TagElement
import org.w3c.dom.HTMLElement
import web.compose.material3.LitElementBuilderImplementation
import web.compose.material3.MdElement

abstract class MdListElement : MdElement()

@Composable
fun List(
    attrs: AttrBuilderContext<MdListElement>? = null,
    content: ContentBuilder<MdListElement>? = null
) = TagElement(
    elementBuilder = ListElementBuilder,
    applyAttrs = attrs,
    content = content
)

private val ListElementBuilder: ElementBuilder<MdListElement> =
    LitElementBuilderImplementation("md-list")
