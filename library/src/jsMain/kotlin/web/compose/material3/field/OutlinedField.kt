package web.compose.material3.field

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import web.compose.material3.jsRequire

@Composable
fun OutlinedField(
    attrs: AttrBuilderContext<MdFieldElement>? = null,
    content: ContentBuilder<MdFieldElement>? = null
) = MdFieldTagElement(
    tagName = "md-outlined-field",
    applyAttrs = attrs,
    content = content
).also {
    webComponentLoader
}

private val webComponentLoader = jsRequire("@material/web/field/outlined-field.js")
