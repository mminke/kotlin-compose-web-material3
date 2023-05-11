package web.compose.material3.progress

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.ElementBuilder
import org.jetbrains.compose.web.dom.TagElement
import web.compose.material3.ElementBuilderImplementation
import web.compose.material3.jsRequire


@Composable
fun LinearProgress(
    attrs: AttrBuilderContext<MdProgressElement>? = null,
    content: ContentBuilder<MdProgressElement>? = null
) = TagElement(
    elementBuilder = LinearProgressElementBuilder,
    applyAttrs = attrs,
    content = content
)

private val LinearProgressElementBuilder: ElementBuilder<MdProgressElement> =
    ElementBuilderImplementation<MdProgressElement>("md-linear-progress").also {
        jsRequire("@material/web/linearprogress/linear-progress.js")
    }

