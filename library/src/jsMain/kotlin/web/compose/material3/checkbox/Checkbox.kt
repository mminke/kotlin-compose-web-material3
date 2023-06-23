package web.compose.material3.checkbox

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import web.compose.material3.MdInputElement
import web.compose.material3.MdTagElement
import web.compose.material3.jsRequire

abstract class CheckboxElement : MdInputElement()

@Composable
fun Checkbox(
    attrs: AttrBuilderContext<CheckboxElement>? = null,
    content: ContentBuilder<CheckboxElement>? = null
) = MdTagElement(
    tagName = "md-checkbox",
    applyAttrs = attrs,
    content = content
).also {
    webComponentLoader
}

private val webComponentLoader = jsRequire("@material/web/checkbox/checkbox.js")

fun AttrsScope<CheckboxElement>.checked(value: Boolean = true) {
    if (value) attr("checked", "")
}

fun AttrsScope<CheckboxElement>.indeterminate(value: Boolean = true) {
    if (value) attr("indeterminate", "")
}
