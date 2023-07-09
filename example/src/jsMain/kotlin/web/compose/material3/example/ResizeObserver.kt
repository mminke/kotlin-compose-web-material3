package web.compose.material3.example

import org.w3c.dom.DOMRectReadOnly
import org.w3c.dom.Element

external class ResizeObserver(
    callback: (entries: Array<ResizeObserverEntry>) -> Unit
) {

    fun observe(target: Element)
    fun unobserver(target: Element)
    fun disconnect()
}

abstract external class ResizeObserverEntry {
    open val target: Element
    open val contentRect: DOMRectReadOnly
    open val borderBoxSize: Array<ResizeObserverSize>
    open val contentBoxSize: Array<ResizeObserverSize>
    open val devicePixelContentBoxSize: Array<ResizeObserverSize>
}

abstract external class ResizeObserverSize {
    open val inlineSize: Double?
    open val blockSize: Double?
}
