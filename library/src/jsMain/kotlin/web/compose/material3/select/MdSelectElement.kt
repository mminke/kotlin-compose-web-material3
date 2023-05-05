package web.compose.material3.select

import androidx.compose.web.events.SyntheticEvent
import org.jetbrains.compose.web.attributes.AttrsScope
import org.w3c.dom.events.EventTarget
import web.compose.material3.InvalidCallException
import web.compose.material3.MdInputElement

abstract class MdSelectElement : MdInputElement()

fun AttrsScope<MdSelectElement>.onChange(handler: (SyntheticEvent<EventTarget>) -> Unit) {
    addEventListener("change") {
        handler(it)
    }
}

fun AttrsScope<MdSelectElement>.required(value: Boolean = true) {
    if (value) attr("required", "")
}

fun AttrsScope<MdSelectElement>.disabled(value: Boolean = true) {
    if (value) attr("disabled", "")
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