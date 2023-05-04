package web.compose.material3.fab

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.ElementBuilder
import org.jetbrains.compose.web.dom.TagElement
import web.compose.material3.ElementBuilderImplementation
import web.compose.material3.InvalidCallException
import web.compose.material3.MdElement
import web.compose.material3.jsRequire


abstract class MdFabElement : MdElement()

@Composable
fun Fab(
    attrs: AttrBuilderContext<MdFabElement>? = null,
    content: ContentBuilder<MdFabElement>? = null
) = TagElement(
    elementBuilder = FabElementBuilder,
    applyAttrs = attrs,
    content = content
)

private val FabElementBuilder: ElementBuilder<MdFabElement> =
    ElementBuilderImplementation<MdFabElement>("md-fab").also {
        jsRequire("@material/web/fab/fab.js")
    }

var AttrsScope<MdFabElement>.label: String
    get() {
        throw InvalidCallException()
    }
    set(value) {
        this.attr("label", value)
    }

var AttrsScope<MdFabElement>.size: FabSize
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
