package web.compose.material3.dialog

import androidx.compose.runtime.Composable
import androidx.compose.web.events.SyntheticEvent
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.dom.*
import org.w3c.dom.events.EventTarget
import web.compose.material3.ElementBuilderImplementation
import web.compose.material3.MdElement
import web.compose.material3.jsRequire
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
    ElementBuilderImplementation<DialogElement>("md-dialog").also {
        jsRequire("@material/web/dialog/dialog.js")
    }

fun AttrsScope<DialogElement>.open(value: Boolean = true) {
    if (value) attr("open", "")
}

fun AttrsScope<DialogElement>.fullscreen(value: Boolean = true) {
    if (value) attr("fullscreen", "")
}

fun AttrsScope<DialogElement>.onOpening(handler: (SyntheticEvent<EventTarget>) -> Unit) {
    addEventListener("opening") {
        handler(it)
    }
}

fun AttrsScope<DialogElement>.onOpened(handler: (SyntheticEvent<EventTarget>) -> Unit) {
    addEventListener("opened") {
        handler(it)
    }
}

fun AttrsScope<DialogElement>.onClosing(handler: (SyntheticEvent<EventTarget>) -> Unit) {
    addEventListener("closing") {
        handler(it)
    }
}

fun AttrsScope<DialogElement>.onClosed(handler: (SyntheticEvent<EventTarget>) -> Unit) {
    addEventListener("closed") {
        handler(it)
    }
}

@Composable
fun ContentBuilder<DialogElement>.headline(content: @Composable () -> Unit) {
    Span({ slot = "headline" }) {
        content()
    }
}
