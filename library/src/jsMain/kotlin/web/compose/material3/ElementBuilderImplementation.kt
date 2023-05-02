package web.compose.material3

import kotlinx.browser.document
import kotlinx.browser.window
import org.jetbrains.compose.web.dom.ElementBuilder
import org.w3c.dom.Element

internal open class ElementBuilderImplementation<TElement : Element>(private val tagName: String) :
    ElementBuilder<TElement> {
    private val el: Element by lazy {
        document.createElement(tagName)
    }

    @Suppress("UNCHECKED_CAST")
    override fun create(): TElement = el.cloneNode() as TElement
}

internal open class LitElementBuilderImplementation<TElement : Element>(private val tagName: String) :
    ElementBuilder<TElement> {

    @Suppress("unused")
    private val el: Element by lazy {
        val customElement: dynamic = window.customElements.get(tagName)
        js("new customElement()")
    }

    @Suppress("UNCHECKED_CAST")
    override fun create(): TElement = el.cloneNode() as TElement
}
