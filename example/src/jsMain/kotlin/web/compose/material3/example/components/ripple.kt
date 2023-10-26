package web.compose.material3.example.components

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Div
import web.compose.extras.text.LargeBody
import web.compose.extras.text.LargeLabel
import web.compose.extras.text.LargeTitle
import web.compose.material3.ripple.Ripple
import web.compose.material3.ripple.disabled
import web.compose.material3.theming.MdSysColorVariables

private object RippleStyleSheet : StyleSheet() {
    val box by style {
        margin(8.px)
        backgroundColor(MdSysColorVariables.mdSysColorPrimaryContainer.value())
        borderWidth(0.px);
        borderRadius(50.percent);
        color(MdSysColorVariables.mdSysColorOnPrimaryContainer.value())
        display(DisplayStyle.Flex)
        justifyContent(JustifyContent.Center)
        alignItems(AlignItems.Center)
        position(Position.Relative) /* This is needed for Focus Ring to work correctly */
        width(80.px)
        height(80.px)
    }
}

@Composable
fun RippleShowcase() {
    Style(RippleStyleSheet)

    LargeTitle("Ripple")

    LargeBody("""
        Click or touch the circle to see the ripple effect.        
    """.trimIndent())

    Div({ classes(RippleStyleSheet.box) }) {
        LargeLabel("default")
        Ripple()
    }

    Div({ classes(RippleStyleSheet.box) }) {
        LargeLabel("disabled")
        Ripple({disabled = true})
    }
}
