package web.compose.material3.select

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import web.compose.material3.jsRequire

@Composable
fun OutlinedSelect(
    attrs: AttrBuilderContext<MdSelectElement>? = null,
    content: ContentBuilder<MdSelectElement>? = null
) = MdSelectTagElement(
    tagName = "md-outlined-select",
    applyAttrs = attrs,
    content = content
).also {
    webComponentLoader
}

private val webComponentLoader = jsRequire("@material/web/select/outlined-select.js")
