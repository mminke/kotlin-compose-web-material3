package web.compose.material3.buttons

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.ElementBuilder
import org.jetbrains.compose.web.dom.TagElement
import org.w3c.dom.Element
import web.compose.material3.ElementBuilderImplementation
import web.compose.material3.InvalidCallException


private val FilledButtonElementBuilder: ElementBuilder<MdFilledButtonElement> =
    ElementBuilderImplementation("md-filled-button")


abstract external class MdFilledButtonElement : Element

@Composable
fun FilledButton(
    attrs: AttrBuilderContext<MdFilledButtonElement>? = null,
    content: ContentBuilder<MdFilledButtonElement>? = null
) = TagElement(
    elementBuilder = FilledButtonElementBuilder,
    applyAttrs = attrs,
    content = content
)

var AttrsScope<MdFilledButtonElement>.label: String
    get() {
        throw InvalidCallException()
    }
    set(value) {
        this.attr("label", value)
    }
