package web.compose.extras.panel

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.ExperimentalComposeWebApi
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Div

@Composable
fun CollapsiblePanel(
    opened: Boolean,
    reverse: Boolean = false,
    animationDuration: CSSSizeValue<out CSSUnitTime> = 1.s,
    panelWidth: CSSLengthValue = 175.px,
    content: (@Composable () -> Unit)? = null
) {
    Div({
        @OptIn(ExperimentalComposeWebApi::class)
        style {
            overflow("hidden")
            if (!opened) {
                width(0.px)
            }
            if (opened) {
                width(panelWidth)
            }

            transitions {
                "width" { duration(animationDuration) }
            }
        }
    }) {
        Div({
            @OptIn(ExperimentalComposeWebApi::class)
            style {
                width(panelWidth)
                if (!opened) {
                    if (!reverse) {
                        transform { translateX(-panelWidth) }
                    }
                }

                transitions {
                    "transform" { duration(animationDuration) }
                }
            }
            addEventListener("transitionend") {
                console.log("Animation ended ")
            }
        }) {
            content?.invoke()
        }
    }
}