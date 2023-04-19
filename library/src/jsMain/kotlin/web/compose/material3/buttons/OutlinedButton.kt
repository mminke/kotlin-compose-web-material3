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

private val OutlinedButtonElementBuilder: ElementBuilder<MdOutlinedButtonElement> =
    ElementBuilderImplementation("md-outlined-button")


abstract external class MdOutlinedButtonElement : Element

@Composable
fun OutlinedButton(
    attrs: AttrBuilderContext<MdOutlinedButtonElement>? = null,
    content: ContentBuilder<MdOutlinedButtonElement>? = null
) = TagElement(
    elementBuilder = OutlinedButtonElementBuilder,
    applyAttrs = attrs,
    content = content
)

var AttrsScope<MdOutlinedButtonElement>.label: String
    get() {
        throw InvalidCallException()
    }
    set(value) {
        this.attr("label", value)
    }
