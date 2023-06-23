package web.compose.material3.select

import androidx.compose.runtime.Composable
import androidx.compose.web.events.SyntheticEvent
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.dom.ElementScope
import org.w3c.dom.events.EventTarget
import web.compose.material3.InvalidCallException
import web.compose.material3.MdInputElement
import web.compose.material3.MdTagElement

abstract class MdSelectElement : MdInputElement()

@Composable
fun <TElement : MdSelectElement> MdSelectTagElement(
    tagName: String,
    applyAttrs: (AttrsScope<TElement>.() -> Unit)?,
    content: (@Composable ElementScope<TElement>.() -> Unit)?
) = MdTagElement(
    tagName = tagName,
    applyAttrs = {
        classes("md-select")
        applyAttrs?.invoke(this)
    },
    content = content
)

fun AttrsScope<MdSelectElement>.onChange(handler: (SyntheticEvent<EventTarget>) -> Unit) {
    addEventListener("change") {
        handler(it)
    }
}

fun AttrsScope<MdSelectElement>.required(value: Boolean = true) {
    if (value) attr("required", "")
}

var AttrsScope<MdSelectElement>.label: String
    get() {
        throw InvalidCallException()
    }
    set(value) {
        this.attr("label", value)
    }

var AttrsScope<MdSelectElement>.supportingText: String
    get() {
        throw InvalidCallException()
    }
    set(value) {
        this.attr("supportingText", value)
    }

var AttrsScope<MdSelectElement>.errorText: String
    get() {
        throw InvalidCallException()
    }
    set(value) {
        this.attr("errorText", value)
    }
