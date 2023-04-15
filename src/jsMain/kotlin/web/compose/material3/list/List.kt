package web.compose.material3.list

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.ElementBuilder
import org.jetbrains.compose.web.dom.TagElement
import org.w3c.dom.HTMLElement
import web.compose.material3.LitElementBuilderImplementation

private val ListElementBuilder: ElementBuilder<MdListElement> =
    LitElementBuilderImplementation("md-list")

abstract external class MdListElement : HTMLElement
//abstract external class MdListElement : ListElement
//
//external abstract class ListElement: LitElement
//
//external abstract class LitElement: ReactiveElement // Not abstract in lit itself
//
//external abstract class ReactiveElement: HTMLElement

@Composable
fun List(
    attrs: AttrBuilderContext<MdListElement>? = null,
    content: ContentBuilder<MdListElement>? = null
) = TagElement(
    elementBuilder = ListElementBuilder,
    applyAttrs = attrs,
    content = content
)

