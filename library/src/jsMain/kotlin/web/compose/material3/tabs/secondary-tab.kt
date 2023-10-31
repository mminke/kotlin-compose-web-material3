package web.compose.material3.tabs

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import web.compose.material3.MdElement
import web.compose.material3.MdTagElement
import web.compose.material3.jsRequire

abstract class MdSecondaryTabElement : MdElement()

@Composable
fun SecondaryTab(
    attrs: AttrBuilderContext<MdSecondaryTabElement>? = null,
    content: ContentBuilder<MdSecondaryTabElement>? = null
) = MdTagElement(
    tagName = "md-secondary-tab",
    applyAttrs = attrs,
    content = content
).also {
    webComponentLoader
}

private val webComponentLoader = jsRequire("@material/web/tabs/secondary-tab.js")

fun AttrsScope<MdSecondaryTabElement>.disabled(value: Boolean = true) {
    if (value) attr("disabled", "")
}

fun AttrsScope<MdSecondaryTabElement>.active(value: Boolean = true) {
    if (value) attr("active", "")
}

fun AttrsScope<MdSecondaryTabElement>.focusable(value: Boolean = true) {
    if (value) attr("focusable", "")
}

fun AttrsScope<MdSecondaryTabElement>.inlineIcon(value: Boolean = true) {
    if (value) attr("inlineIcon", "")
}
