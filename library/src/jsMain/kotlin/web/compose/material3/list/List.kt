package web.compose.material3.list

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import web.compose.material3.MdInputElement
import web.compose.material3.MdTagElement
import web.compose.material3.jsRequire

abstract class MdListElement : MdInputElement()

@Composable
fun List(
    attrs: AttrBuilderContext<MdListElement>? = null,
    content: ContentBuilder<MdListElement>? = null
) = MdTagElement(
    tagName = "md-list",
    applyAttrs = attrs,
    content = content
).also {
    webComponentLoader
}

private val webComponentLoader = jsRequire("@material/web/list/list.js")
