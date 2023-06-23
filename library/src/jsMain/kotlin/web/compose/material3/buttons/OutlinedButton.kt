package web.compose.material3.buttons

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import web.compose.material3.jsRequire

@Composable
fun OutlinedButton(
    attrs: AttrBuilderContext<MdButtonElement>? = null,
    content: ContentBuilder<MdButtonElement>? = null
) = MdButtonTagElement(
    tagName = "md-outlined-button",
    applyAttrs = attrs,
    content = content
).also {
    webComponentLoader
}

private val webComponentLoader = jsRequire("@material/web/button/outlined-button.js")
