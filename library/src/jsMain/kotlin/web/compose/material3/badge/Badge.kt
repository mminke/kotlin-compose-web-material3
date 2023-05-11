package web.compose.material3.badge

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.ElementBuilder
import org.jetbrains.compose.web.dom.TagElement
import web.compose.material3.ElementBuilderImplementation
import web.compose.material3.InvalidCallException
import web.compose.material3.MdInputElement
import web.compose.material3.jsRequire

abstract class BadgeElement : MdInputElement()

@Composable
fun Badge(
    attrs: AttrBuilderContext<BadgeElement>? = null,
    content: ContentBuilder<BadgeElement>? = null
) = TagElement(
    elementBuilder = BadgeElementBuilder,
    applyAttrs = attrs,
    content = content
)

private val BadgeElementBuilder: ElementBuilder<BadgeElement> =
    ElementBuilderImplementation<BadgeElement>("md-badge").also {
        jsRequire("@material/web/badge/badge.js")
    }

var AttrsScope<BadgeElement>.value: String
    get() {
        throw InvalidCallException()
    }
    set(value) {
        this.attr("value", value)
    }
