package web.compose.material3.switch

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import web.compose.material3.MdInputElement
import web.compose.material3.MdTagElement
import web.compose.material3.jsRequire

abstract class SwitchElement : MdInputElement()

@Composable
fun Switch(
    attrs: AttrBuilderContext<SwitchElement>? = null,
    content: ContentBuilder<SwitchElement>? = null
) = MdTagElement(
    tagName = "md-switch",
    applyAttrs = attrs,
    content = content
).also {
    webComponentLoader
}

private val webComponentLoader = jsRequire("@material/web/switch/switch.js")

fun AttrsScope<SwitchElement>.selected(value: Boolean = true) {
    if (value) attr("selected", "")
}

fun AttrsScope<SwitchElement>.icons(value: Boolean = true) {
    if (value) attr("icons", "")
}

fun AttrsScope<SwitchElement>.showOnlySelectedIcon(value: Boolean = true) {
    if (value) attr("showOnlySelectedIcon", "")
}
