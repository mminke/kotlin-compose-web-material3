package web.compose.material3.fab

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.ElementBuilder
import org.jetbrains.compose.web.dom.TagElement
import org.w3c.dom.BoxQuadOptions
import org.w3c.dom.ConvertCoordinateOptions
import org.w3c.dom.DOMPoint
import org.w3c.dom.DOMPointInit
import org.w3c.dom.DOMQuad
import org.w3c.dom.DOMRectReadOnly
import org.w3c.dom.Element
import org.w3c.dom.HTMLCollection
import org.w3c.dom.NodeList
import web.compose.material3.ElementBuilderImplementation
import web.compose.material3.InvalidCallException
import web.compose.material3.MdElement

private val FabElementBuilder: ElementBuilder<MdElement> =
    ElementBuilderImplementation("md-fab")

@Composable
fun Fab(
    attrs: AttrBuilderContext<MdElement>? = null,
    content: ContentBuilder<MdElement>? = null
) = TagElement(
    elementBuilder = FabElementBuilder,
    applyAttrs = attrs,
    content = content
)
