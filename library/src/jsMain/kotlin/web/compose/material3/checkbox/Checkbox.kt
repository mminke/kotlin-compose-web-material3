import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.ElementBuilder
import org.jetbrains.compose.web.dom.TagElement
import web.compose.material3.ElementBuilderImplementation
import web.compose.material3.MdInputElement
import web.compose.material3.jsRequire

abstract class CheckboxElement : MdInputElement()

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
    ElementBuilderImplementation<CheckboxElement>("md-checkbox").also {
        jsRequire("@material/web/checkbox/checkbox.js")
    }

fun AttrsScope<CheckboxElement>.checked(value: Boolean = true) {
    if (value) attr("checked", "")
}
