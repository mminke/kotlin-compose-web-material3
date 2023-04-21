package web.compose.material3.fab

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.ElementBuilder
import org.jetbrains.compose.web.dom.TagElement
import web.compose.material3.ElementBuilderImplementation
import web.compose.material3.InvalidCallException
import web.compose.material3.MaterialTheme
import web.compose.material3.buttons.MdButtonElement

@Composable
fun Fab(
    attrs: AttrBuilderContext<MdButtonElement>? = null,
    content: ContentBuilder<MdButtonElement>? = null
) = TagElement(
    elementBuilder = FabElementBuilder,
    applyAttrs = attrs,
    content = content
)

private val FabElementBuilder: ElementBuilder<MdButtonElement> =
    ElementBuilderImplementation("md-fab")

var AttrsScope<MdButtonElement>.size: FabSize
    get() {
        throw InvalidCallException()
    }
    set(fabSize) {
        this.attr("size", fabSize.value)
    }

enum class FabSize(val value: String) {
    SMALL("small"),
    MEDIUM("medium"),
    LARGE("large")
}