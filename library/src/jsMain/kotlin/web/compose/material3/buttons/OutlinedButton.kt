package web.compose.material3.buttons

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.ElementBuilder
import org.jetbrains.compose.web.dom.TagElement
import web.compose.material3.ElementBuilderImplementation
import web.compose.material3.MaterialTheme

@Composable
fun OutlinedButton(
    attrs: AttrBuilderContext<MdButtonElement>? = null,
    content: ContentBuilder<MdButtonElement>? = null
) = TagElement(
    elementBuilder = OutlinedButtonElementBuilder,
    applyAttrs = attrs,
    content = content
)

private val OutlinedButtonElementBuilder: ElementBuilder<MdButtonElement> =
    ElementBuilderImplementation("md-outlined-button")
