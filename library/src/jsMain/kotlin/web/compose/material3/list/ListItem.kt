package web.compose.material3.list

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import web.compose.material3.InvalidCallException
import web.compose.material3.MdElement
import web.compose.material3.MdTagElement
import web.compose.material3.jsRequire

abstract class MdListItemElement : MdElement()

@Composable
fun ListItem(
    attrs: AttrBuilderContext<MdListItemElement>? = null,
    content: ContentBuilder<MdListItemElement>? = null
) = MdTagElement(
    tagName = "md-list-item",
    applyAttrs = attrs,
    content = content
).also {
    webComponentLoader
}

private val webComponentLoader = jsRequire("@material/web/list/list-item.js")

var AttrsScope<MdListItemElement>.headline: String
    get() {
        throw InvalidCallException()
    }
    set(value) {
        this.attr("headline", value)
    }

var AttrsScope<MdListItemElement>.supportingText: String
    get() {
        throw InvalidCallException()
    }
    set(value) {
        this.attr("supportingText", value)
    }
