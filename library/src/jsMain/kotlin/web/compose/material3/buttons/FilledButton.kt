package web.compose.material3.buttons

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.ElementBuilder
import org.jetbrains.compose.web.dom.TagElement
import web.compose.material3.ElementBuilderImplementation
import web.compose.material3.MaterialTheme

@Composable
fun FilledButton(
    attrs: AttrBuilderContext<MdButtonElement>? = null,
    content: ContentBuilder<MdButtonElement>? = null
) = TagElement(
    elementBuilder = FilledButtonElementBuilder,
    applyAttrs = attrs,
    content = content
)

private val FilledButtonElementBuilder: ElementBuilder<MdButtonElement> =
    ElementBuilderImplementation("md-filled-button")
