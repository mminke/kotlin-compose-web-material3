package web.compose.material3.buttons

import org.jetbrains.compose.web.attributes.AttrsScope
import web.compose.material3.InvalidCallException
import web.compose.material3.MdElement

abstract class MdButtonElement : MdElement()

var AttrsScope<MdButtonElement>.label: String
    get() {
        throw InvalidCallException()
    }
    set(value) {
        this.attr("label", value)
    }