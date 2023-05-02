package web.compose.material3.select

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.ElementBuilder
import org.jetbrains.compose.web.dom.TagElement
import web.compose.material3.ElementBuilderImplementation
import web.compose.material3.InvalidCallException
import web.compose.material3.MdElement

abstract class MdSelectElement : MdElement()

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