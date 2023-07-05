package web.compose.material3.focusring

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.dom.AttrBuilderContext
import web.compose.material3.InvalidCallException
import web.compose.material3.MdElement
import web.compose.material3.MdTagElement
import web.compose.material3.jsRequire

abstract class FocusRingElement : MdElement()

@Composable
fun FocusRing(
    attrs: AttrBuilderContext<FocusRingElement>? = null,
) = MdTagElement(
    tagName = "md-focus-ring",
    applyAttrs = attrs,
    content = null
).also {
    webComponentLoader
}

private val webComponentLoader = jsRequire("@material/web/focus/focus-ring.js")

var AttrsScope<FocusRingElement>.visible: Boolean
    get() = throw InvalidCallException()
    set(value) {
        if(value) this.attr("visible", "")
    }

var AttrsScope<FocusRingElement>.inward: Boolean
    get() = throw InvalidCallException()
    set(value) {
        if(value) this.attr("inward", "")
    }
