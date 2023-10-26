package web.compose.extras.layout

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.css.DisplayStyle.Companion.Flex
import org.jetbrains.compose.web.css.FlexDirection.Companion.Column
import org.jetbrains.compose.web.dom.Div
import org.w3c.dom.HTMLElement

private typealias AttributeBuilder = AttrsScope<HTMLElement>.() -> Unit
private typealias ContentBuilder = @Composable () -> Unit

private object BorderLayoutStyleSheet : StyleSheet() {
    val borderLayout by style {
        display(Flex)
        flexDirection(Column)
        height(100.percent)
    }
    val north by style {
        flex(1)
        margin(0.px)
        padding(0.px)
    }
    val middle by style {
        display(Flex)
        flex(999)
        overflow("hidden")
        margin(0.px)
        padding(0.px)
    }
    val center by style {
        flex(999)
        overflow("auto")
        margin(0.px)
        padding(0.px)
    }
    val south by style {
        flex(1)
        margin(0.px)
        padding(0.px)
    }
    val east by style {
        flex(1)
    }
    val west by style {
        flex(1)
    }
}

@Composable
fun BorderLayout(
    attrs: AttributeBuilder? = null,
    buildContent: @Composable BorderLayoutBuilder.() -> Unit
) {
    val borderLayoutBuilder = BorderLayoutBuilder()
    borderLayoutBuilder.buildContent()

    Style(BorderLayoutStyleSheet)

    Div({
        classes(BorderLayoutStyleSheet.borderLayout)
        attrs?.invoke(this)
    }) {
        Div({
            classes(BorderLayoutStyleSheet.north)
            borderLayoutBuilder.northAttrs?.invoke(this)
        }) {
            borderLayoutBuilder.northContent?.invoke()
        }

        Div({ classes(BorderLayoutStyleSheet.middle) }) {
            Div({
                classes(BorderLayoutStyleSheet.west)
                borderLayoutBuilder.westAttrs?.invoke(this)
            }) {
                borderLayoutBuilder.westContent?.invoke()
            }

            Div({
                classes(BorderLayoutStyleSheet.center)
                borderLayoutBuilder.centerAttrs?.invoke(this)
            }) {
                borderLayoutBuilder.centerContent?.invoke()
            }

            Div({
                classes(BorderLayoutStyleSheet.east)
                borderLayoutBuilder.eastAttrs?.invoke(this)
            }) {
                borderLayoutBuilder.eastContent?.invoke()
            }
        }

        Div({
            classes(BorderLayoutStyleSheet.south)
            borderLayoutBuilder.southAttrs?.invoke(this)
        }) {
            borderLayoutBuilder.southContent?.invoke()
        }
    }
}

class BorderLayoutBuilder {
    var northAttrs: AttributeBuilder? = null
        private set
    var northContent: ContentBuilder? = null
        private set
    var eastAttrs: AttributeBuilder? = null
        private set
    var eastContent: ContentBuilder? = null
        private set
    var centerAttrs: AttributeBuilder? = null
        private set
    var centerContent: ContentBuilder? = null
        private set
    var westAttrs: AttributeBuilder? = null
        private set
    var westContent: ContentBuilder? = null
        private set
    var southAttrs: AttributeBuilder? = null
        private set
    var southContent: ContentBuilder? = null
        private set

    fun North(
        attrs: AttributeBuilder? = null,
        content: ContentBuilder? = null
    ) {
        northAttrs = attrs
        northContent = content
    }

    fun West(
        attrs: AttributeBuilder? = null,
        content: ContentBuilder? = null
    ) {
        westAttrs = attrs
        westContent = content
    }

    fun Center(
        attrs: AttributeBuilder? = null,
        content: ContentBuilder? = null
    ) {
        centerAttrs = attrs
        centerContent = content
    }

    fun East(
        attrs: AttributeBuilder? = null,
        content: ContentBuilder? = null
    ) {
        eastAttrs = attrs
        eastContent = content
    }

    fun South(
        attrs: AttributeBuilder? = null,
        content: ContentBuilder? = null
    ) {
        southAttrs = attrs
        southContent = content
    }
}
