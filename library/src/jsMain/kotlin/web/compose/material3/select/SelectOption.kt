package web.compose.material3.select

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

abstract class MdSelectOptionElement : MdElement()

@Composable
fun SelectOption(
    attrs: AttrBuilderContext<MdSelectOptionElement>? = null,
    content: ContentBuilder<MdSelectOptionElement>? = null
) = TagElement(
    elementBuilder = MdSelectOptionElementBuilder,
    applyAttrs = attrs,
    content = content
)

private val MdSelectOptionElementBuilder: ElementBuilder<MdSelectOptionElement> =
    ElementBuilderImplementation<MdSelectOptionElement>("md-select-option").also {
        jsRequire("@material/web/select/select-option.js")
    }

var AttrsScope<MdSelectOptionElement>.value: String
    get() {
        throw InvalidCallException()
    }
    set(value) {
        this.attr("value", value)
    }

var AttrsScope<MdSelectOptionElement>.headline: String
    get() {
        throw InvalidCallException()
    }
    set(value) {
        this.attr("headline", value)
    }
