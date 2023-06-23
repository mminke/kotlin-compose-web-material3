package web.compose.material3.textfield

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.dom.ElementScope
import web.compose.material3.InvalidCallException
import web.compose.material3.MdInputElement
import web.compose.material3.MdTagElement

abstract class MdTextFieldElement : MdInputElement()

@Composable
fun <TElement : MdTextFieldElement> MdTextFieldTagElement(
    tagName: String,
    applyAttrs: (AttrsScope<TElement>.() -> Unit)?,
    content: (@Composable ElementScope<TElement>.() -> Unit)?
) = MdTagElement(
    tagName = tagName,
    applyAttrs = {
        classes("md-text-field")
        applyAttrs?.invoke(this)
    },
    content = content
)

var AttrsScope<MdTextFieldElement>.type: TextFieldType
    get() = throw InvalidCallException()
    set(type) {
        this.attr("type", type.value)
    }

var AttrsScope<MdTextFieldElement>.required: Boolean
    get() = throw InvalidCallException()
    set(value) {
        if (value) attr("required", "")
    }

var AttrsScope<MdTextFieldElement>.error: Boolean
    get() = throw InvalidCallException()
    set(value) {
        if (value) attr("error", "")
    }

var AttrsScope<MdTextFieldElement>.errorText: String
    get() = throw InvalidCallException()
    set(value) {
        this.attr("errorText", value)
    }

var AttrsScope<MdTextFieldElement>.label: String
    get() = throw InvalidCallException()
    set(value) {
        this.attr("label", value)
    }

var AttrsScope<MdTextFieldElement>.value: String
    get() = throw InvalidCallException()
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

