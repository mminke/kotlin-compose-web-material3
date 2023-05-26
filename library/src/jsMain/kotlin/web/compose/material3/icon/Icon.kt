package web.compose.material3.icon

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ElementBuilder
import org.jetbrains.compose.web.dom.TagElement
import org.jetbrains.compose.web.dom.Text
import web.compose.material3.ElementBuilderImplementation
import web.compose.material3.MdElement
import web.compose.material3.jsRequire

abstract class MdIconElement : MdElement()

@Composable
fun Icon(
    attrs: AttrBuilderContext<MdIconElement>? = null,
    iconIdentifier: String
) = TagElement(
    elementBuilder = IconElementBuilder,
    applyAttrs = attrs,
    content = { Text(iconIdentifier) }
)

@Composable
fun Icon(
    iconIdentifier: String
) = TagElement(
    elementBuilder = IconElementBuilder,
    applyAttrs = {},
    content = { Text(iconIdentifier) }
)

private val IconElementBuilder: ElementBuilder<MdIconElement> =
    ElementBuilderImplementation<MdIconElement>("md-icon").also {
        jsRequire("@material/web/icon/icon.js")
    }
