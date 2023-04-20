package web.compose.material3.icon

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.ElementBuilder
import org.jetbrains.compose.web.dom.TagElement
import org.w3c.dom.Element
import web.compose.material3.ElementBuilderImplementation
import web.compose.material3.InvalidCallException
import web.compose.material3.MaterialTheme

abstract class MdIconElement : Element()

@Composable
fun MaterialTheme.Icon(
    attrs: AttrBuilderContext<MdIconElement>? = null,
    content: ContentBuilder<MdIconElement>? = null
) = TagElement(
    elementBuilder = IconElementBuilder,
    applyAttrs = attrs,
    content = content
)

private val IconElementBuilder: ElementBuilder<MdIconElement> =
    ElementBuilderImplementation("md-icon")

var AttrsScope<MdIconElement>.dataVariant: DataVariant
    get() {
        throw InvalidCallException()
    }
    set(dataVariant) {
        this.attr("data-variant", dataVariant.value)
    }

var AttrsScope<MdIconElement>.slot: Slot
    get() {
        throw InvalidCallException()
    }
    set(slot) {
        this.attr("slot", slot.value)
    }

enum class DataVariant(val value: String) {
    ICON("icon")
}

enum class Slot(val value: String) {
    START("start"),
    END("end"),
    ICON("icon")
}
