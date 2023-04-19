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


private val TextButtonElementBuilder: ElementBuilder<MdTextButtonElement> =
    ElementBuilderImplementation("md-text-button")


abstract external class MdTextButtonElement : Element

@Composable
fun TextButton(
    attrs: AttrBuilderContext<MdTextButtonElement>? = null,
    content: ContentBuilder<MdTextButtonElement>? = null
) = TagElement(
    elementBuilder = TextButtonElementBuilder,
    applyAttrs = attrs,
    content = content
)

var AttrsScope<MdTextButtonElement>.label: String
    get() {
        throw InvalidCallException()
    }
    set(value) {
        this.attr("label", value)
    }
