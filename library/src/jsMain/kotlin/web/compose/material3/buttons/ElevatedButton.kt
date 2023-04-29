package web.compose.material3.buttons

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.ElementBuilder
import org.jetbrains.compose.web.dom.TagElement
import web.compose.material3.ElementBuilderImplementation

@Composable
fun ElevatedButton(
    attrs: AttrBuilderContext<MdButtonElement>? = null,
    content: ContentBuilder<MdButtonElement>? = null
) = TagElement(
    elementBuilder = ElevatedButtonElementBuilder,
    applyAttrs = attrs,
    content = content
)

private val ElevatedButtonElementBuilder: ElementBuilder<MdButtonElement> =
    ElementBuilderImplementation("md-elevated-button")

