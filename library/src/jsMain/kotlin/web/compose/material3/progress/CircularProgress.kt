package web.compose.material3.progress

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import web.compose.material3.jsRequire

@Composable
fun CircularProgress(
    attrs: AttrBuilderContext<MdProgressElement>? = null,
    content: ContentBuilder<MdProgressElement>? = null
) = MdProgressTagElement(
    tagName = "md-circular-progress",
    applyAttrs = attrs,
    content = content
).also {
    webComponentLoader
}

private val webComponentLoader = jsRequire("@material/web/progress/circular-progress.js")
