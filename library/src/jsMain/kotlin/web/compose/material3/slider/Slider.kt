package web.compose.material3.slider

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import web.compose.material3.InvalidCallException
import web.compose.material3.MdInputElement
import web.compose.material3.MdTagElement
import web.compose.material3.jsRequire

abstract class SliderElement : MdInputElement()

@Composable
fun Slider(
    attrs: AttrBuilderContext<SliderElement>? = null,
    content: ContentBuilder<SliderElement>? = null
) = MdTagElement(
    tagName = "md-slider",
    applyAttrs = attrs,
    content = content
).also {
    webComponentLoader
}

private val webComponentLoader = jsRequire("@material/web/slider/slider.js")

var AttrsScope<SliderElement>.min: Long
    get() {
        throw InvalidCallException()
    }
    set(value) {
        this.attr("min", value.toString())
    }

var AttrsScope<SliderElement>.max: Long
    get() {
        throw InvalidCallException()
    }
    set(value) {
        this.attr("max", value.toString())
    }

var AttrsScope<SliderElement>.step: Long
    get() {
        throw InvalidCallException()
    }
    set(value) {
        this.attr("step", value.toString())
    }

var AttrsScope<SliderElement>.value: Long
    get() {
        throw InvalidCallException()
    }
    set(value) {
        this.attr("value", value.toString())
    }

var AttrsScope<SliderElement>.valueLabel: String
    get() {
        throw InvalidCallException()
    }
    set(value) {
        this.attr("valueLabel", value)
    }

fun AttrsScope<SliderElement>.withTickMarks(value: Boolean = true) {
    if (value) attr("withTickMarks", "")
}

fun AttrsScope<SliderElement>.withLabel(value: Boolean = true) {
    if (value) attr("withLabel", "")
}
