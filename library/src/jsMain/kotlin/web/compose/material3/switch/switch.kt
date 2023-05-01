import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.ElementBuilder
import org.jetbrains.compose.web.dom.TagElement
import web.compose.material3.ElementBuilderImplementation
import web.compose.material3.MdElement

abstract class SwitchElement : MdElement()

@Composable
fun Switch(
    attrs: AttrBuilderContext<SwitchElement>? = null,
    content: ContentBuilder<SwitchElement>? = null
) = TagElement(
    elementBuilder = SwitchElementBuilder,
    applyAttrs = attrs,
    content = content
)

private val SwitchElementBuilder: ElementBuilder<SwitchElement> =
    ElementBuilderImplementation("md-switch")

fun AttrsScope<SwitchElement>.disabled(value: Boolean = true) {
    if (value) attr("disabled", "")
}

fun AttrsScope<SwitchElement>.selected(value: Boolean = true) {
    if (value) attr("selected", "")
}

fun AttrsScope<SwitchElement>.icons(value: Boolean = true) {
    if (value) attr("icons", "")
}

fun AttrsScope<SwitchElement>.showOnlySelectedIcon(value: Boolean = true) {
    if (value) attr("showOnlySelectedIcon", "")
}
