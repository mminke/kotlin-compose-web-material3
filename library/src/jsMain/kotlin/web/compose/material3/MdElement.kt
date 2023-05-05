package web.compose.material3

import androidx.compose.web.events.SyntheticEvent
import org.jetbrains.compose.web.attributes.AttrsScope
import org.w3c.dom.Element
import org.w3c.dom.events.EventTarget

abstract class MdElement : Element()

abstract class MdInputElement : MdElement()

fun AttrsScope<MdInputElement>.onChange(handler: (SyntheticEvent<EventTarget>) -> Unit) {
    addEventListener("change") {
        handler(it)
    }
}

var AttrsScope<Element>.slot: String
    get() {
        throw InvalidCallException()
    }
    set(value) {
        this.attr("slot", value)
    }