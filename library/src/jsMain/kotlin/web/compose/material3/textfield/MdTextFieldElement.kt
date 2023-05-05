package web.compose.material3.textfield

import org.jetbrains.compose.web.attributes.AttrsScope
import web.compose.material3.InvalidCallException
import web.compose.material3.MdInputElement

abstract class MdTextFieldElement : MdInputElement()

var AttrsScope<MdTextFieldElement>.type: TextFieldType
    get() {
        throw InvalidCallException()
    }
    set(type) {
        this.attr("type", type.value)
    }

var AttrsScope<MdTextFieldElement>.required: Boolean
    get() {
        throw InvalidCallException()
    }
    set(value) {
        this.attr("required", value.toString())
    }

var AttrsScope<MdTextFieldElement>.error: Boolean
    get() {
        throw InvalidCallException()
    }
    set(value) {
        this.attr("error", value.toString())
    }

var AttrsScope<MdTextFieldElement>.errorText: String
    get() {
        throw InvalidCallException()
    }
    set(value) {
        this.attr("errorText", value)
    }

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

enum class TextFieldType(val value: String) {
    EMAIL("email"),
    NUMBER("number"),
    PASSWORD("password"),
    SEARCH("search"),
    TEXT("text"),
    URL("url")
}

