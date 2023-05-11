package web.compose.material3.progress

import org.jetbrains.compose.web.attributes.AttrsScope
import web.compose.material3.InvalidCallException
import web.compose.material3.MdInputElement

abstract class MdProgressElement : MdInputElement()

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
