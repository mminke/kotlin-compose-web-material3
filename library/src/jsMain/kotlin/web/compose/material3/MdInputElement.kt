package web.compose.material3

import androidx.compose.web.events.SyntheticEvent
import org.jetbrains.compose.web.attributes.AttrsScope
import org.w3c.dom.events.EventTarget

abstract class MdInputElement : MdElement()

fun AttrsScope<MdInputElement>.disabled(value: Boolean = true) {
    if (value) attr("disabled", "")
}

fun AttrsScope<MdInputElement>.onChange(handler: (SyntheticEvent<EventTarget>) -> Unit) {
    addEventListener("change") {
        handler(it)
    }
}
