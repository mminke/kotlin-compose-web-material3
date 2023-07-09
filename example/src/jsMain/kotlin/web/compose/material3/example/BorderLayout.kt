package web.compose.material3.example

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.css.DisplayStyle.Companion.Flex
import org.jetbrains.compose.web.css.FlexDirection.Companion.Column
import org.jetbrains.compose.web.dom.Div
import org.w3c.dom.HTMLElement

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
        border(1.px, LineStyle.Dashed, Color.red)
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

        backgroundColor(Color.gray)
        borderRadius(25.px)

        border(1.px, LineStyle.Dashed, Color.yellow)
    }
    val south by style {
        flex(1)
        margin(0.px)
        padding(0.px)

        border(1.px, LineStyle.Dashed, Color.blue)
    }
    val east by style {
        flex(1)
    }
    val west by style {
        flex(1)

        /**
         *   -webkit-transition: all 2s ease;
         *   -moz-transition: all 2s ease;
         *   -o-transition: all 2s ease;
         *   -ms-transition: all 2s ease;
         *   transition: all 2s ease;
         */
    }
}

@Composable
fun BorderLayout(
    buildContent: @Composable BorderLayoutBuilder.() -> Unit
) {
    val borderLayoutBuilder = BorderLayoutBuilder()
    borderLayoutBuilder.buildContent()

    Style(BorderLayoutStyleSheet)

    Div({ classes(BorderLayoutStyleSheet.borderLayout) }) {
        Div({ classes(BorderLayoutStyleSheet.north) }) {
            borderLayoutBuilder.northContent?.invoke()
        }
        Div({classes(BorderLayoutStyleSheet.middle)}) {
            Div({
                classes(BorderLayoutStyleSheet.west)
                borderLayoutBuilder.westAttrs?.invoke(this)
            }) {
                borderLayoutBuilder.westContent?.invoke()
            }
            Div({ classes(BorderLayoutStyleSheet.center) }) {
                borderLayoutBuilder.centerContent?.invoke()
            }
            Div({classes(BorderLayoutStyleSheet.east)}) {
                borderLayoutBuilder.eastContent?.invoke()
            }
        }

        Div({ classes(BorderLayoutStyleSheet.south) }) {
            borderLayoutBuilder.southContent?.invoke()
        }
    }
}

class BorderLayoutBuilder {
    var northContent: (@Composable () -> Unit)? = null
        private set
    var centerContent: (@Composable () -> Unit)? = null
        private set
    var southContent: (@Composable () -> Unit)? = null
        private set
    var eastContent: (@Composable () -> Unit)? = null
        private set

    var westAttrs: (AttrsScope<HTMLElement>.() -> Unit)? = null
        private set
    var westContent: (@Composable () -> Unit)? = null
        private set

    fun North(content: @Composable () -> Unit) {
        northContent = content
    }
    fun Center(content: @Composable () -> Unit) {
        centerContent = content
    }
    fun South(content: @Composable () -> Unit) {
        southContent = content
    }
    fun East(content: @Composable () -> Unit) {
        eastContent = content
    }
    fun West(
        attrs: (AttrsScope<HTMLElement>.() -> Unit)? = null,
        content: (@Composable () -> Unit)
    ) {
        westAttrs = attrs
        westContent = content
    }
}
