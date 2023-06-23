package web.compose.material3.tabs

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import web.compose.material3.MdElement
import web.compose.material3.MdTagElement
import web.compose.material3.jsRequire

abstract class MdTabElement : MdElement()

@Composable
fun Tab(
    attrs: AttrBuilderContext<MdTabElement>? = null,
    content: ContentBuilder<MdTabElement>? = null
) = MdTagElement(
    tagName = "md-tab",
    applyAttrs = attrs,
    content = content
).also {
    webComponentLoader
}

private val webComponentLoader = jsRequire("@material/web/tabs/tab.js")

fun AttrsScope<MdTabElement>.disabled(value: Boolean = true) {
    if (value) attr("disabled", "")
}

fun AttrsScope<MdTabElement>.selected(value: Boolean = true) {
    if (value) attr("selected", "")
}

fun AttrsScope<MdTabElement>.focusable(value: Boolean = true) {
    if (value) attr("focusable", "")
}

fun AttrsScope<MdTabElement>.inlineIcon(value: Boolean = true) {
    if (value) attr("inlineIcon", "")
}
