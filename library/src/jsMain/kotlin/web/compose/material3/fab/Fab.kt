package web.compose.material3.fab

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.ElementBuilder
import org.jetbrains.compose.web.dom.TagElement
import web.compose.material3.ElementBuilderImplementation
import web.compose.material3.MaterialTheme
import web.compose.material3.MdElement

@Composable
fun MaterialTheme.Fab(
    attrs: AttrBuilderContext<MdElement>? = null,
    content: ContentBuilder<MdElement>? = null
) = TagElement(
    elementBuilder = FabElementBuilder,
    applyAttrs = attrs,
    content = content
)

private val FabElementBuilder: ElementBuilder<MdElement> =
    ElementBuilderImplementation("md-fab")
