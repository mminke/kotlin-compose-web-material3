package web.compose.material3.progress

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.ElementBuilder
import org.jetbrains.compose.web.dom.TagElement
import web.compose.material3.ElementBuilderImplementation
import web.compose.material3.jsRequire

@Composable
fun CircularProgress(
    attrs: AttrBuilderContext<MdProgressElement>? = null,
    content: ContentBuilder<MdProgressElement>? = null
) = TagElement(
    elementBuilder = CircularProgressElementBuilder,
    applyAttrs = attrs,
    content = content
)

private val CircularProgressElementBuilder: ElementBuilder<MdProgressElement> =
    ElementBuilderImplementation<MdProgressElement>("md-circular-progress").also {
        jsRequire("@material/web/circularprogress/circular-progress.js")
    }

