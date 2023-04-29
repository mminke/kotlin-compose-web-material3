package web.compose.material3

import org.jetbrains.compose.web.attributes.AttrsScope
import org.w3c.dom.Element

abstract class MdElement : Element()

var AttrsScope<Element>.slot: String
    get() {
        throw InvalidCallException()
    }
    set(value) {
        this.attr("slot", value)
    }