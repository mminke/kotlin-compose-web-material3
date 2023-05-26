package web.compose.material3.tabs

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
import web.compose.material3.switch.SwitchElement

abstract class MdTabsElement : MdElement()

@Composable
fun Tabs(
    attrs: AttrBuilderContext<MdTabsElement>? = null,
    content: ContentBuilder<MdTabsElement>? = null
) = TagElement(
    elementBuilder = TabElementBuilder,
    applyAttrs = attrs,
    content = content
)

private val TabElementBuilder: ElementBuilder<MdTabsElement> =
    ElementBuilderImplementation<MdTabsElement>("md-tabs").also {
        jsRequire("@material/web/tabs/tabs.js")
    }

var AttrsScope<MdTabsElement>.variant: Variant
    get() {
        throw InvalidCallException()
    }
    set(variant) {
        this.attr("variant", variant.value)
    }

var AttrsScope<MdTabsElement>.selected: Int
    get() {
        throw InvalidCallException()
    }
    set(value) {
        this.attr("selected", value.toString())
    }

fun AttrsScope<SwitchElement>.disabled(value: Boolean = true) {
    if (value) attr("disabled", "")
}

fun AttrsScope<SwitchElement>.selectOnFocus(value: Boolean = true) {
    if (value) attr("selectOnFocus", "")
}

enum class Variant(val value: String) {
    PRIMARY("primary"),
    SECONDARY("secondary")
}