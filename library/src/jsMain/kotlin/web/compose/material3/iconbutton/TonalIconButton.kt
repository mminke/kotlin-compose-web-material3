package web.compose.material3.iconbutton

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import web.compose.material3.jsRequire

@Composable
fun TonalIconButton(
    attrs: AttrBuilderContext<MdIconButtonElement>? = null,
    content: ContentBuilder<MdIconButtonElement>? = null
) = MdIconButtonTagElement(
    tagName = "md-filled-tonal-icon-button",
    applyAttrs = attrs,
    content = content
).also {
    webComponentLoader
}

private val webComponentLoader = jsRequire("@material/web/iconbutton/filled-tonal-icon-button.js")
