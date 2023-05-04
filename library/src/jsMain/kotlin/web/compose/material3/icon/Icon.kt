package web.compose.material3.icon

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.ElementBuilder
import org.jetbrains.compose.web.dom.TagElement
import web.compose.material3.ElementBuilderImplementation
import web.compose.material3.InvalidCallException
import web.compose.material3.MdElement
import web.compose.material3.jsRequire

abstract class MdIconElement : MdElement()

@Composable
fun Icon(
    attrs: AttrBuilderContext<MdIconElement>? = null,
    content: ContentBuilder<MdIconElement>? = null
) = TagElement(
    elementBuilder = IconElementBuilder,
    applyAttrs = attrs,
    content = content
)

private val IconElementBuilder: ElementBuilder<MdIconElement> =
    ElementBuilderImplementation<MdIconElement>("md-icon").also {
        jsRequire("@material/web/icon/icon.js")
    }

var AttrsScope<MdIconElement>.dataVariant: DataVariant
    get() {
        throw InvalidCallException()
    }
    set(dataVariant) {
        this.attr("data-variant", dataVariant.value)
    }

enum class DataVariant(val value: String) {
    ICON("icon")
}
