package web.compose.material3.buttons

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.ElementBuilder
import org.jetbrains.compose.web.dom.TagElement
import web.compose.material3.ElementBuilderImplementation


private val TonalButtonElementBuilder: ElementBuilder<MdButtonElement> =
    ElementBuilderImplementation("md-tonal-button")

@Composable
fun TonalButton(
    attrs: AttrBuilderContext<MdButtonElement>? = null,
    content: ContentBuilder<MdButtonElement>? = null
) = TagElement(
    elementBuilder = TonalButtonElementBuilder,
    applyAttrs = attrs,
    content = content
)
