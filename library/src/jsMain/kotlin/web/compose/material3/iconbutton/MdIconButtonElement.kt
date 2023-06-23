package web.compose.material3.iconbutton

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.dom.ElementScope
import web.compose.material3.MdElement
import web.compose.material3.MdTagElement

abstract class MdIconButtonElement : MdElement()

@Composable
fun <TElement : MdIconButtonElement> MdIconButtonTagElement(
    tagName: String,
    applyAttrs: (AttrsScope<TElement>.() -> Unit)?,
    content: (@Composable ElementScope<TElement>.() -> Unit)?
) = MdTagElement(
    tagName = tagName,
    applyAttrs = {
        classes("md-icon-button")
        applyAttrs?.invoke(this)
    },
    content = content
)

fun AttrsScope<MdIconButtonElement>.toggle(value: Boolean = true) {
    if (value) attr("toggle", "")
}

fun AttrsScope<MdIconButtonElement>.selected(value: Boolean = true) {
    if (value) attr("selected", "")
}

fun AttrsScope<MdIconButtonElement>.disabled(value: Boolean = true) {
    if (value) attr("disabled", "")
}
