package web.compose.material3.iconbutton

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.ElementBuilder
import org.jetbrains.compose.web.dom.TagElement
import web.compose.material3.ElementBuilderImplementation
import web.compose.material3.jsRequire

@Composable
fun StandardIconButton(
    attrs: AttrBuilderContext<MdIconButtonElement>? = null,
    content: ContentBuilder<MdIconButtonElement>? = null
) = TagElement(
    elementBuilder = StandardIconButtonElementBuilder,
    applyAttrs = attrs,
    content = content
)

private val StandardIconButtonElementBuilder: ElementBuilder<MdIconButtonElement> =
    ElementBuilderImplementation<MdIconButtonElement>("md-standard-icon-button").also {
        jsRequire("@material/web/iconbutton/standard-icon-button.js")
    }
