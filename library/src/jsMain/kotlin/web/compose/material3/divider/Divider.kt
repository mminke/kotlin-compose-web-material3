package web.compose.material3.divider

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import web.compose.material3.MdElement
import web.compose.material3.MdTagElement
import web.compose.material3.jsRequire

@Composable
fun Divider(
    attrs: AttrBuilderContext<MdElement>? = null,
    content: ContentBuilder<MdElement>? = null
) = MdTagElement(
    tagName = "md-divider",
    applyAttrs = attrs,
    content = content
).also {
    webComponentLoader
}

private val webComponentLoader = jsRequire("@material/web/divider/divider.js")
