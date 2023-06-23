package web.compose.material3.badge

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import web.compose.material3.InvalidCallException
import web.compose.material3.MdInputElement
import web.compose.material3.MdTagElement
import web.compose.material3.jsRequire

abstract class BadgeElement : MdInputElement()

@Composable
fun Badge(
    attrs: AttrBuilderContext<BadgeElement>? = null,
    content: ContentBuilder<BadgeElement>? = null
) = MdTagElement(
    tagName = "md-badge",
    applyAttrs = attrs,
    content = content
).also {
    webComponentLoader
}

private val webComponentLoader = jsRequire("@material/web/labs/badge/badge.js")

var AttrsScope<BadgeElement>.value: String
    get() {
        throw InvalidCallException()
    }
    set(value) {
        this.attr("value", value)
    }
