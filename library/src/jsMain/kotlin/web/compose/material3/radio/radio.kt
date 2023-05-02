import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.ElementBuilder
import org.jetbrains.compose.web.dom.TagElement
import web.compose.material3.ElementBuilderImplementation
import web.compose.material3.InvalidCallException
import web.compose.material3.MdElement

abstract class RadioElement : MdElement()

@Composable
fun Radio(
    attrs: AttrBuilderContext<RadioElement>? = null,
    content: ContentBuilder<RadioElement>? = null
) = TagElement(
    elementBuilder = RadioElementBuilder,
    applyAttrs = attrs,
    content = content
)

private val RadioElementBuilder: ElementBuilder<RadioElement> =
    ElementBuilderImplementation("md-radio")

fun AttrsScope<RadioElement>.disabled(value: Boolean = true) {
    if (value) attr("disabled", "")
}

var AttrsScope<RadioElement>.name: String
    get() {
        throw InvalidCallException()
    }
    set(value) {
        this.attr("name", value)
    }

var AttrsScope<RadioElement>.value: String
    get() {
        throw InvalidCallException()
    }
    set(value) {
        this.attr("value", value)
    }
