package web.compose.material3.tabs

import androidx.compose.runtime.Composable
import androidx.compose.web.events.SyntheticEvent
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import org.w3c.dom.events.EventTarget
import web.compose.material3.InvalidCallException
import web.compose.material3.MdElement
import web.compose.material3.MdTagElement
import web.compose.material3.jsRequire

abstract class MdTabsElement : MdElement()

@Composable
fun Tabs(
    attrs: AttrBuilderContext<MdTabsElement>? = null,
    content: ContentBuilder<MdTabsElement>? = null
) = MdTagElement(
    tagName = "md-tabs",
    applyAttrs = attrs,
    content = content
).also {
    webComponentLoader
}

private val webComponentLoader = jsRequire("@material/web/tabs/tabs.js")

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

fun AttrsScope<MdTabsElement>.disabled(value: Boolean = true) {
    if (value) attr("disabled", "")
}

fun AttrsScope<MdTabsElement>.selectOnFocus(value: Boolean = true) {
    if (value) attr("selectOnFocus", "")
}

fun AttrsScope<MdTabsElement>.onChange(handler: (SyntheticEvent<EventTarget>) -> Unit) {
    addEventListener("change") {
        handler(it)
    }
}

enum class Variant(val value: String) {
    PRIMARY("primary"),
    SECONDARY("secondary")
}
