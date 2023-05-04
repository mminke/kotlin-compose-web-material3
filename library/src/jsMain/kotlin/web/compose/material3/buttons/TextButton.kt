package web.compose.material3.buttons

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.ElementBuilder
import org.jetbrains.compose.web.dom.TagElement
import web.compose.material3.ElementBuilderImplementation
import web.compose.material3.jsRequire

@Composable
fun TextButton(
    attrs: AttrBuilderContext<MdButtonElement>? = null,
    content: ContentBuilder<MdButtonElement>? = null
) = TagElement(
    elementBuilder = TextButtonElementBuilder,
    applyAttrs = attrs,
    content = content
)

private val TextButtonElementBuilder: ElementBuilder<MdButtonElement> =
    ElementBuilderImplementation<MdButtonElement>("md-text-button").also {
        jsRequire("@material/web/button/text-button.js")
    }
