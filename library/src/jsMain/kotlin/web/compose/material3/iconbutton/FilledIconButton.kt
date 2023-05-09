package web.compose.material3.iconbutton

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.ElementBuilder
import org.jetbrains.compose.web.dom.TagElement
import web.compose.material3.ElementBuilderImplementation
import web.compose.material3.jsRequire

@Composable
fun FilledIconButton(
    attrs: AttrBuilderContext<MdIconButtonElement>? = null,
    content: ContentBuilder<MdIconButtonElement>? = null
) = TagElement(
    elementBuilder = FilledIconButtonElementBuilder,
    applyAttrs = attrs,
    content = content
)

private val FilledIconButtonElementBuilder: ElementBuilder<MdIconButtonElement> =
    ElementBuilderImplementation<MdIconButtonElement>("md-filled-icon-button").also {
        jsRequire("@material/web/iconbutton/filled-icon-button.js")
    }
