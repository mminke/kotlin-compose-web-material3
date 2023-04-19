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


private val TonalButtonElementBuilder: ElementBuilder<MdTonalButtonElement> =
    ElementBuilderImplementation("md-tonal-button")


abstract external class MdTonalButtonElement : Element

@Composable
fun TonalButton(
    attrs: AttrBuilderContext<MdTonalButtonElement>? = null,
    content: ContentBuilder<MdTonalButtonElement>? = null
) = TagElement(
    elementBuilder = TonalButtonElementBuilder,
    applyAttrs = attrs,
    content = content
)

var AttrsScope<MdTonalButtonElement>.label: String
    get() {
        throw InvalidCallException()
    }
    set(value) {
        this.attr("label", value)
    }
