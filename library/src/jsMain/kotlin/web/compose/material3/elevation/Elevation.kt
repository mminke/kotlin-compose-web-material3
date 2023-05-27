package web.compose.material3.elevation

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.css.CSSStyleVariable
import org.jetbrains.compose.web.css.StylePropertyNumber
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ElementBuilder
import org.jetbrains.compose.web.dom.TagElement
import web.compose.material3.ElementBuilderImplementation
import web.compose.material3.MdElement
import web.compose.material3.jsRequire

abstract class ElevationElement : MdElement()

@Composable
fun Elevation(level: Int) = Elevation { style { mdElevationLevel(level) } }

@Composable
fun Elevation(
    attrs: AttrBuilderContext<ElevationElement>? = null,
) = TagElement(
    elementBuilder = ElevationElementBuilder,
    applyAttrs = attrs,
    content = null
)

private val ElevationElementBuilder: ElementBuilder<ElevationElement> =
    ElementBuilderImplementation<ElevationElement>("md-elevation").also {
        jsRequire("@material/web/elevation/elevation.js")
    }

val mdElevationLevel = CSSStyleVariable<StylePropertyNumber>("--md-elevation-level")
