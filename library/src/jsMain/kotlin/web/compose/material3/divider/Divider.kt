package web.compose.material3.divider

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import web.compose.material3.MdElement
import web.compose.material3.MdTagElement
import web.compose.material3.jsRequire

abstract class DividerElement : MdElement()

@Composable
fun Divider(
    inset: Boolean = false,
    insetStart: Boolean = false,
    insetEnd: Boolean = false
) = Divider({
    this.inset(inset)
    this.insetStart(insetStart)
    this.insetEnd(insetEnd)
})

@Composable
fun Divider(
    attrs: AttrBuilderContext<DividerElement>? = null,
    content: ContentBuilder<DividerElement>? = null
) = MdTagElement(
    tagName = "md-divider",
    applyAttrs = attrs,
    content = content
).also {
    webComponentLoader
}

private val webComponentLoader = jsRequire("@material/web/divider/divider.js")

fun AttrsScope<DividerElement>.inset(value: Boolean = true) {
    if (value) attr("inset", "")
}

fun AttrsScope<DividerElement>.insetStart(value: Boolean = true) {
    if (value) attr("inset-start", "")
}

fun AttrsScope<DividerElement>.insetEnd(value: Boolean = true) {
    if (value) attr("inset-end", "")
}
