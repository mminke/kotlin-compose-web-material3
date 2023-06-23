package web.compose.material3.select

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import web.compose.material3.InvalidCallException
import web.compose.material3.MdElement
import web.compose.material3.MdTagElement
import web.compose.material3.jsRequire

abstract class MdSelectOptionElement : MdElement()

@Composable
fun SelectOption(
    attrs: AttrBuilderContext<MdSelectOptionElement>? = null,
    content: ContentBuilder<MdSelectOptionElement>? = null
) = MdTagElement(
    tagName = "md-select-option",
    applyAttrs = attrs,
    content = content
).also {
    webComponentLoader
}

private val webComponentLoader = jsRequire("@material/web/select/select-option.js")

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
