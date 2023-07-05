package web.compose.material3.example.components

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Div
import web.compose.extras.text.LargeBody
import web.compose.extras.text.LargeLabel
import web.compose.extras.text.LargeTitle
import web.compose.material3.focusring.FocusRing
import web.compose.material3.focusring.inward
import web.compose.material3.focusring.visible
import web.compose.material3.theming.MdSysColorVariables

private object FocusRingStyleSheet : StyleSheet() {
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
fun FocusRingShowcase() {
    Style(FocusRingStyleSheet)

    LargeTitle("Focus Ring")

    LargeBody("""
        Use the keyboard <Tab> key to change focus of elements. This should trigger the focus ring.        
    """.trimIndent())

    Div({ tabIndex(1); classes(FocusRingStyleSheet.box) }) {
        LargeLabel("default")
        FocusRing()
    }

    Div({ tabIndex(2); classes(FocusRingStyleSheet.box) }) {
        LargeLabel("inward")
        FocusRing({inward = true})
    }

    Div({ tabIndex(3); classes(FocusRingStyleSheet.box) }) {
        LargeLabel("visible")
        FocusRing({visible = true})
    }
}
