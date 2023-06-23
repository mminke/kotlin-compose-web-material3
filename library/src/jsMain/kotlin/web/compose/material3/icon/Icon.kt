package web.compose.material3.icon

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.Text
import web.compose.material3.MdElement
import web.compose.material3.MdTagElement
import web.compose.material3.jsRequire

abstract class MdIconElement : MdElement()

@Composable
fun Icon(
    iconIdentifier: String
) = Icon({}, iconIdentifier)

@Composable
fun Icon(
    attrs: AttrBuilderContext<MdIconElement>? = null,
    iconIdentifier: String
) = MdTagElement(
    tagName = "md-icon",
    applyAttrs = attrs,
    content = { Text(iconIdentifier) }
).also {
    webComponentLoader
}

private val webComponentLoader = jsRequire("@material/web/icon/icon.js")
