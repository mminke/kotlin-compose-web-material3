package web.compose.material3.field

import org.jetbrains.compose.web.attributes.AttrsScope
import web.compose.material3.InvalidCallException
import web.compose.material3.MdElement

abstract class MdFieldElement : MdElement()

fun AttrsScope<MdFieldElement>.error(value: Boolean = true) {
    if (value) attr("error", "")
}

var AttrsScope<MdFieldElement>.errorText: String
    get() {
        throw InvalidCallException()
    }
    set(value) {
        this.attr("errorText", value)
    }

var AttrsScope<MdFieldElement>.label: String
    get() {
        throw InvalidCallException()
    }
    set(value) {
        this.attr("label", value)
    }

var AttrsScope<MdFieldElement>.value: String
    get() {
        throw InvalidCallException()
    }
    set(value) {
        this.attr("value", value)
    }
