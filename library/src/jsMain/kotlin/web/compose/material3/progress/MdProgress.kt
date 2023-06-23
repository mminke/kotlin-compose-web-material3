package web.compose.material3.progress

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.dom.ElementScope
import web.compose.material3.InvalidCallException
import web.compose.material3.MdInputElement
import web.compose.material3.MdTagElement

abstract class MdProgressElement : MdInputElement()

@Composable
fun <TElement : MdProgressElement> MdProgressTagElement(
    tagName: String,
    applyAttrs: (AttrsScope<TElement>.() -> Unit)?,
    content: (@Composable ElementScope<TElement>.() -> Unit)?
) = MdTagElement(
    tagName = tagName,
    applyAttrs = {
        classes("md-progress")
        applyAttrs?.invoke(this)
    },
    content = content
)

var AttrsScope<MdProgressElement>.progress: Progress
    get() {
        throw InvalidCallException()
    }
    set(progress) {
        this.attr("progress", progress.value.toString())
    }

var AttrsScope<MdProgressElement>.buffer: Buffer
    get() {
        throw InvalidCallException()
    }
    set(buffer) {
        this.attr("buffer", buffer.value.toString())
    }

fun AttrsScope<MdProgressElement>.indeterminate(value: Boolean = true) {
    if (value) attr("indeterminate", "")
}

fun AttrsScope<MdProgressElement>.fourColor(value: Boolean = true) {
    if (value) attr("four-color", "")
}

value class Progress(val value: Float) {
    init {
        require(value >= 0 && value <= 1) { }
    }
}

value class Buffer(val value: Float) {
    init {
        require(value >= 0 && value <= 1) { }
    }
}
