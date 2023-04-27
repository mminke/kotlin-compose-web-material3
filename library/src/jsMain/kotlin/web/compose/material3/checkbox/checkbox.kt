import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.ElementBuilder
import org.jetbrains.compose.web.dom.TagElement
import org.w3c.dom.Element
import web.compose.material3.ElementBuilderImplementation

abstract external class CheckboxElement : Element

@Composable
fun Checkbox(
    attrs: AttrBuilderContext<CheckboxElement>? = null,
    content: ContentBuilder<CheckboxElement>? = null
) = TagElement(
    elementBuilder = CheckboxElementBuilder,
    applyAttrs = attrs,
    content = content
)

private val CheckboxElementBuilder: ElementBuilder<CheckboxElement> =
    ElementBuilderImplementation("md-checkbox")

fun AttrsScope<CheckboxElement>.checked(value: Boolean = true) {
    if(value) attr("checked", "")
}
