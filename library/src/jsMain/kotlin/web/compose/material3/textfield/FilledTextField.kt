package web.compose.material3.textfield

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import web.compose.material3.jsRequire

@Composable
fun FilledTextField(
    attrs: AttrBuilderContext<MdTextFieldElement>? = null,
    content: ContentBuilder<MdTextFieldElement>? = null
) = MdTextFieldTagElement(
    tagName = "md-filled-text-field",
    applyAttrs = attrs,
    content = content
).also {
    webComponentLoader
}

private val webComponentLoader = jsRequire("@material/web/textfield/filled-text-field.js")
