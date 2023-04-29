package web.compose.material3.elevation

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.ElementBuilder
import org.jetbrains.compose.web.dom.TagElement
import org.w3c.dom.Element
import web.compose.material3.ElementBuilderImplementation

abstract external class ElevationElement : Element

@Composable
fun Elevation(
    attrs: AttrBuilderContext<ElevationElement>? = null,
    content: ContentBuilder<ElevationElement>? = null
) = TagElement(
    elementBuilder = ElevationElementBuilder,
    applyAttrs = attrs,
    content = content
)

private val ElevationElementBuilder: ElementBuilder<ElevationElement> =
    ElementBuilderImplementation("md-elevation")
