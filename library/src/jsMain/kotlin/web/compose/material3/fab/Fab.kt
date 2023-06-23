package web.compose.material3.fab

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import web.compose.material3.InvalidCallException
import web.compose.material3.MdInputElement
import web.compose.material3.MdTagElement
import web.compose.material3.jsRequire

abstract class MdFabElement : MdInputElement()

@Composable
fun Fab(
    attrs: AttrBuilderContext<MdFabElement>? = null,
    content: ContentBuilder<MdFabElement>? = null
) = MdTagElement(
    tagName = "md-fab",
    applyAttrs = attrs,
    content = content
).also {
    webComponentLoader
}

private val webComponentLoader = jsRequire("@material/web/fab/fab.js")

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
