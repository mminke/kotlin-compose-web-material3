package web.compose.material3.field

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.ElementBuilder
import org.jetbrains.compose.web.dom.TagElement
import web.compose.material3.ElementBuilderImplementation
import web.compose.material3.jsRequire

@Composable
fun OutlinedField(
    attrs: AttrBuilderContext<MdFieldElement>? = null,
    content: ContentBuilder<MdFieldElement>? = null
) = TagElement(
    elementBuilder = OutlinedFieldElementBuilder,
    applyAttrs = attrs,
    content = content
)

private val OutlinedFieldElementBuilder: ElementBuilder<MdFieldElement> =
    ElementBuilderImplementation<MdFieldElement>("md-outlined-field").also {
        jsRequire("@material/web/field/outlined-field.js")
    }
