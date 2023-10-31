package web.compose.material3.tabs

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import web.compose.material3.MdElement
import web.compose.material3.MdTagElement
import web.compose.material3.jsRequire

abstract class MdPrimaryTabElement : MdElement()

@Composable
fun PrimaryTab(
    attrs: AttrBuilderContext<MdPrimaryTabElement>? = null,
    content: ContentBuilder<MdPrimaryTabElement>? = null
) = MdTagElement(
    tagName = "md-primary-tab",
    applyAttrs = attrs,
    content = content
).also {
    webComponentLoader
}

private val webComponentLoader = jsRequire("@material/web/tabs/primary-tab.js")

fun AttrsScope<MdPrimaryTabElement>.disabled(value: Boolean = true) {
    if (value) attr("disabled", "")
}

fun AttrsScope<MdPrimaryTabElement>.active(value: Boolean = true) {
    if (value) attr("active", "")
}

fun AttrsScope<MdPrimaryTabElement>.focusable(value: Boolean = true) {
    if (value) attr("focusable", "")
}

fun AttrsScope<MdPrimaryTabElement>.inlineIcon(value: Boolean = true) {
    if (value) attr("inlineIcon", "")
}
