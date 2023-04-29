package web.compose.material3.textfield

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.ElementBuilder
import org.jetbrains.compose.web.dom.TagElement
import web.compose.material3.ElementBuilderImplementation

@Composable
fun OutlinedTextField(
    attrs: AttrBuilderContext<MdTextFieldElement>? = null,
    content: ContentBuilder<MdTextFieldElement>? = null
) = TagElement(
    elementBuilder = OutlinedTextFieldElementBuilder,
    applyAttrs = attrs,
    content = content
)

private val OutlinedTextFieldElementBuilder: ElementBuilder<MdTextFieldElement> =
    ElementBuilderImplementation("md-outlined-text-field")
