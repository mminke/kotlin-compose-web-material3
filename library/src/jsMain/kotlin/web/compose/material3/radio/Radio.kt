package web.compose.material3.radio

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import web.compose.material3.InvalidCallException
import web.compose.material3.MdInputElement
import web.compose.material3.MdTagElement
import web.compose.material3.jsRequire

abstract class RadioElement : MdInputElement()

@Composable
fun Radio(
    attrs: AttrBuilderContext<RadioElement>? = null,
    content: ContentBuilder<RadioElement>? = null
) = MdTagElement(
    tagName = "md-radio",
    applyAttrs = attrs,
    content = content
).also {
    webComponentLoader
}

private val webComponentLoader = jsRequire("@material/web/radio/radio.js")

fun AttrsScope<RadioElement>.checked(value: Boolean = true) {
    if (value) attr("checked", "")
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
