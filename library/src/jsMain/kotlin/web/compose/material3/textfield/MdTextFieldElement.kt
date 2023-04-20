package web.compose.material3.textfield

import org.jetbrains.compose.web.attributes.AttrsScope
import web.compose.material3.InvalidCallException
import web.compose.material3.MdElement

abstract class MdTextFieldElement : MdElement()

var AttrsScope<MdTextFieldElement>.label: String
    get() {
        throw InvalidCallException()
    }
    set(value) {
        this.attr("label", value)
    }

var AttrsScope<MdTextFieldElement>.value: String
    get() {
        throw InvalidCallException()
    }
    set(value) {
        this.attr("value", value)
    }

fun AttrsScope<MdTextFieldElement>.onInput(handler: (MdInputEventWrapper) -> Unit) {
    addEventListener("input") {
        handler(MdInputEventWrapper(it))
    }
}
