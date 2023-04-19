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


private val ElevatedButtonElementBuilder: ElementBuilder<MdElevatedButtonElement> =
    ElementBuilderImplementation("md-elevated-button")


abstract external class MdElevatedButtonElement : Element

@Composable
fun ElevatedButton(
    attrs: AttrBuilderContext<MdElevatedButtonElement>? = null,
    content: ContentBuilder<MdElevatedButtonElement>? = null
) = TagElement(
    elementBuilder = ElevatedButtonElementBuilder,
    applyAttrs = attrs,
    content = content
)

var AttrsScope<MdElevatedButtonElement>.label: String
    get() {
        throw InvalidCallException()
    }
    set(value) {
        this.attr("label", value)
    }
