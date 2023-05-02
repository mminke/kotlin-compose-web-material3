package web.compose.material3.select

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.ElementBuilder
import org.jetbrains.compose.web.dom.TagElement
import web.compose.material3.ElementBuilderImplementation
import web.compose.material3.InvalidCallException
import web.compose.material3.MdElement

@Composable
fun OutlinedSelect(
    attrs: AttrBuilderContext<MdSelectElement>? = null,
    content: ContentBuilder<MdSelectElement>? = null
) = TagElement(
    elementBuilder = OutlinedSelectElementBuilder,
    applyAttrs = attrs,
    content = content
)

private val OutlinedSelectElementBuilder: ElementBuilder<MdSelectElement> =
    ElementBuilderImplementation("md-outlined-select")
