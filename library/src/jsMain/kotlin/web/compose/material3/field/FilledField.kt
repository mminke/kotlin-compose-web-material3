package web.compose.material3.field

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.ElementBuilder
import org.jetbrains.compose.web.dom.TagElement
import web.compose.material3.ElementBuilderImplementation
import web.compose.material3.jsRequire

@Composable
fun FilledField(
    attrs: AttrBuilderContext<MdFieldElement>? = null,
    content: ContentBuilder<MdFieldElement>? = null
) = TagElement(
    elementBuilder = FilledFieldElementBuilder,
    applyAttrs = attrs,
    content = content
)

private val FilledFieldElementBuilder: ElementBuilder<MdFieldElement> =
    ElementBuilderImplementation<MdFieldElement>("md-filled-field").also {
        jsRequire("@material/web/field/filled-field.js")
    }
