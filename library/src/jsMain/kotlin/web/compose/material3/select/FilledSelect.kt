package web.compose.material3.select

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import web.compose.material3.jsRequire

@Composable
fun FilledSelect(
    attrs: AttrBuilderContext<MdSelectElement>? = null,
    content: ContentBuilder<MdSelectElement>? = null
) = MdSelectTagElement(
    tagName = "md-filled-select",
    applyAttrs = attrs,
    content = content
).also {
    webComponentLoader
}

private val webComponentLoader = jsRequire("@material/web/select/filled-select.js")
