package web.compose.material3.ripple

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.dom.AttrBuilderContext
import web.compose.material3.InvalidCallException
import web.compose.material3.MdElement
import web.compose.material3.MdTagElement
import web.compose.material3.jsRequire

abstract class RippleElement : MdElement()

@Composable
fun Ripple(
    attrs: AttrBuilderContext<RippleElement>? = null,
) = MdTagElement(
    tagName = "md-ripple",
    applyAttrs = attrs,
    content = null
).also {
    webComponentLoader
}

private val webComponentLoader = jsRequire("@material/web/ripple/ripple.js")

var AttrsScope<RippleElement>.disabled: Boolean
    get() = throw InvalidCallException()
    set(value) {
        if(value) this.attr("disabled", "")
    }
