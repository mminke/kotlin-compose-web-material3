package web.compose.material3.buttons

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.dom.ElementScope
import web.compose.material3.MdElement
import web.compose.material3.MdTagElement

abstract class MdButtonElement : MdElement()

@Composable
fun <TElement : MdButtonElement> MdButtonTagElement(
    tagName: String,
    applyAttrs: (AttrsScope<TElement>.() -> Unit)?,
    content: (@Composable ElementScope<TElement>.() -> Unit)?
) = MdTagElement(
    tagName = tagName,
    applyAttrs = {
        classes("md-button")
        applyAttrs?.invoke(this)
    },
    content = content
)
