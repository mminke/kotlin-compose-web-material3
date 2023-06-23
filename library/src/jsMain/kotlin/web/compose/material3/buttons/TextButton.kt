package web.compose.material3.buttons

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import web.compose.material3.jsRequire

@Composable
fun TextButton(
    attrs: AttrBuilderContext<MdButtonElement>? = null,
    content: ContentBuilder<MdButtonElement>? = null
) = MdButtonTagElement(
    tagName = "md-text-button",
    applyAttrs = attrs,
    content = content
).also {
    webComponentLoader
}

private val webComponentLoader = jsRequire("@material/web/button/text-button.js")
