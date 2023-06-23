package web.compose.material3.elevation

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.css.CSSStyleVariable
import org.jetbrains.compose.web.css.StylePropertyNumber
import org.jetbrains.compose.web.dom.AttrBuilderContext
import web.compose.material3.MdElement
import web.compose.material3.MdTagElement
import web.compose.material3.jsRequire

abstract class ElevationElement : MdElement()

@Composable
fun Elevation(level: Int) = Elevation { style { mdElevationLevel(level) } }

@Composable
fun Elevation(
    attrs: AttrBuilderContext<ElevationElement>? = null,
) = MdTagElement(
    tagName = "md-elevation",
    applyAttrs = attrs,
    content = null
).also {
    webComponentLoader
}

private val webComponentLoader = jsRequire("@material/web/elevation/elevation.js")

val mdElevationLevel = CSSStyleVariable<StylePropertyNumber>("--md-elevation-level")
