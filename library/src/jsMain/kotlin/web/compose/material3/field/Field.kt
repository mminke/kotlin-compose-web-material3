package web.compose.material3.field

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.dom.ElementScope
import web.compose.material3.InvalidCallException
import web.compose.material3.MdElement
import web.compose.material3.MdTagElement

abstract class MdFieldElement : MdElement()

@Composable
fun <TElement : MdFieldElement> MdFieldTagElement(
    tagName: String,
    applyAttrs: (AttrsScope<TElement>.() -> Unit)?,
    content: (@Composable ElementScope<TElement>.() -> Unit)?
) = MdTagElement(
    tagName = tagName,
    applyAttrs = {
        classes("md-field")
        applyAttrs?.invoke(this)
    },
    content = content
)

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
