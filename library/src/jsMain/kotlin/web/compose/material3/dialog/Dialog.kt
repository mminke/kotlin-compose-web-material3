package web.compose.material3.dialog

import androidx.compose.runtime.Composable
import androidx.compose.web.events.SyntheticEvent
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.ElementBuilder
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.TagElement
import org.w3c.dom.events.EventTarget
import web.compose.material3.ElementBuilderImplementation
import web.compose.material3.MdElement
import web.compose.material3.slot

abstract class DialogElement : MdElement()

@Composable
fun Dialog(
    attrs: AttrBuilderContext<DialogElement>? = null,
    content: ContentBuilder<DialogElement>? = null
) = TagElement(
    elementBuilder = DialogElementBuilder,
    applyAttrs = attrs,
    content = content
)

private val DialogElementBuilder: ElementBuilder<DialogElement> =
    ElementBuilderImplementation("md-dialog")

fun AttrsScope<DialogElement>.open(value: Boolean = true) {
    if (value) attr("open", "")
}

fun AttrsScope<DialogElement>.fullscreen(value: Boolean = true) {
    if (value) attr("fullscreen", "")
}

fun AttrsScope<DialogElement>.onCancel(handler: (SyntheticEvent<EventTarget>) -> Unit) {
    addEventListener("cancel") {
        handler(it)
    }
}

fun AttrsScope<DialogElement>.onClose(handler: (SyntheticEvent<EventTarget>) -> Unit) {
    addEventListener("close") {
        handler(it)
    }
}

@Composable
fun ContentBuilder<DialogElement>.headline(content: @Composable () -> Unit) {
    Span({ slot = "headline" }) {
        content()
    }
}