package web.compose.material3.progress

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import web.compose.material3.jsRequire


@Composable
fun LinearProgress(
    attrs: AttrBuilderContext<MdProgressElement>? = null,
    content: ContentBuilder<MdProgressElement>? = null
) = MdProgressTagElement(
    tagName = "md-linear-progress",
    applyAttrs = attrs,
    content = content
).also {
    webComponentLoader
}

private val webComponentLoader = jsRequire("@material/web/progress/linear-progress.js")
