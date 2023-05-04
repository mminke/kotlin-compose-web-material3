package web.compose.material3.select

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.ElementBuilder
import org.jetbrains.compose.web.dom.TagElement
import web.compose.material3.ElementBuilderImplementation
import web.compose.material3.jsRequire

@Composable
fun FilledSelect(
    attrs: AttrBuilderContext<MdSelectElement>? = null,
    content: ContentBuilder<MdSelectElement>? = null
) = TagElement(
    elementBuilder = FilledSelectElementBuilder,
    applyAttrs = attrs,
    content = content
)

private val FilledSelectElementBuilder: ElementBuilder<MdSelectElement> =
    ElementBuilderImplementation<MdSelectElement>("md-filled-select").also {
        jsRequire("@material/web/select/filled-select.js")
    }
