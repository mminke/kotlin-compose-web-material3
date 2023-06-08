package web.compose.material3.navigationtab

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.ElementBuilder
import org.jetbrains.compose.web.dom.TagElement
import web.compose.material3.ElementBuilderImplementation
import web.compose.material3.InvalidCallException
import web.compose.material3.MdElement
import web.compose.material3.jsRequire

abstract class NavigationTabElement : MdElement()

@Composable
fun NavigationTab(
    attrs: AttrBuilderContext<NavigationTabElement>? = null,
    content: ContentBuilder<NavigationTabElement>? = null
) = TagElement(
    elementBuilder = NavigationTabElementBuilder,
    applyAttrs = attrs,
    content = content
)

private val NavigationTabElementBuilder: ElementBuilder<NavigationTabElement> =
    ElementBuilderImplementation<NavigationTabElement>("md-navigation-tab").also {
        jsRequire("@material/web/labs/navigationtab/navigation-tab.js")
    }

var AttrsScope<NavigationTabElement>.label: String
    get() {
        throw InvalidCallException()
    }
    set(value) {
        this.attr("label", value)
    }
