package web.compose.material3.list

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.ElementBuilder
import org.jetbrains.compose.web.dom.TagElement
import web.compose.material3.InvalidCallException
import web.compose.material3.LitElementBuilderImplementation
import web.compose.material3.MdElement
import web.compose.material3.jsRequire

abstract class MdListItemElement : MdElement()

@Composable
fun ListItem(
    attrs: AttrBuilderContext<MdListItemElement>? = null,
    content: ContentBuilder<MdListItemElement>? = null
) = TagElement(
    elementBuilder = ListItemElementBuilder,
    applyAttrs = attrs,
    content = content
)

private val ListItemElementBuilder: ElementBuilder<MdListItemElement> =
    LitElementBuilderImplementation<MdListItemElement>("md-list-item").also {
        jsRequire("@material/web/list/list-item.js")
    }

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
