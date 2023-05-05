package web.compose.material3.list

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.ElementBuilder
import org.jetbrains.compose.web.dom.TagElement
import web.compose.material3.LitElementBuilderImplementation
import web.compose.material3.MdInputElement
import web.compose.material3.jsRequire

abstract class MdListElement : MdInputElement()

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
    LitElementBuilderImplementation<MdListElement>("md-list").also {
        jsRequire("@material/web/list/list.js")
    }
