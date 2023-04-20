package web.compose.material3.list

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.ElementBuilder
import org.jetbrains.compose.web.dom.TagElement
import org.w3c.dom.Element
import web.compose.material3.InvalidCallException
import web.compose.material3.LitElementBuilderImplementation
import web.compose.material3.MaterialTheme

abstract class MdListItemElement : Element()

@Composable
fun MaterialTheme.ListItem(
    attrs: AttrBuilderContext<MdListItemElement>? = null,
    content: ContentBuilder<MdListItemElement>? = null
) = TagElement(
    elementBuilder = ListItemElementBuilder,
    applyAttrs = attrs,
    content = content
)

private val ListItemElementBuilder: ElementBuilder<MdListItemElement> =
    LitElementBuilderImplementation("md-list-item")

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