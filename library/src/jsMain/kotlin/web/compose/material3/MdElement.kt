package web.compose.material3

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.dom.ElementBuilder
import org.jetbrains.compose.web.dom.ElementScope
import org.jetbrains.compose.web.dom.TagElement
import org.w3c.dom.Element

@Composable
fun <TElement : MdElement> MdTagElement(
    tagName: String,
    applyAttrs: (AttrsScope<TElement>.() -> Unit)?,
    content: (@Composable ElementScope<TElement>.() -> Unit)?
) = TagElement(
    elementBuilder = ElementBuilder.createBuilder(tagName),
    applyAttrs = applyAttrs,
    content = content
)

abstract class MdElement : Element()

var AttrsScope<Element>.slot: String
    get() {
        throw InvalidCallException()
    }
    set(value) {
        this.attr("slot", value)
    }
