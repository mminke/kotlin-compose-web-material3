package web.compose.material3.textfield

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.ElementBuilder
import org.jetbrains.compose.web.dom.TagElement
import web.compose.material3.ElementBuilderImplementation
import web.compose.material3.MaterialTheme

@Composable
fun FilledTextField(
    attrs: AttrBuilderContext<MdTextFieldElement>? = null,
    content: ContentBuilder<MdTextFieldElement>? = null
) = TagElement(
    elementBuilder = FilledTextFieldElementBuilder,
    applyAttrs = attrs,
    content = content
)

private val FilledTextFieldElementBuilder: ElementBuilder<MdTextFieldElement> =
    ElementBuilderImplementation("md-filled-text-field")
