package web.compose.material3.example.components

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Div
import web.compose.extras.text.LargeBody
import web.compose.extras.text.LargeTitle
import web.compose.material3.elevation.Elevation
import web.compose.material3.theming.MdSysColorVariables

private object ElevationStyleSheet : StyleSheet() {
    val box by style {
        margin(8.px)
        backgroundColor(MdSysColorVariables.mdSysColorPrimaryContainer.value())
        borderWidth(0.px);
        borderRadius(16.px);
        color(MdSysColorVariables.mdSysColorOnPrimaryContainer.value())
        display(DisplayStyle.Flex)
        justifyContent(JustifyContent.Center)
        position(Position.Relative) /* This is needed for Elevation to work correctly */
        width(80.px)
    }
}

@Composable
fun ElevationShowcase() {

    LargeTitle("Elevation")

    Style(ElevationStyleSheet)

    Div({ classes(ElevationStyleSheet.box) }) {
        LargeBody("Level 0")
        Elevation(0)
    }
    Div({ classes(ElevationStyleSheet.box) }) {
        LargeBody("Level 1")
        Elevation(1)
    }
    Div({ classes(ElevationStyleSheet.box) }) {
        LargeBody("Level 2")
        Elevation(2)
    }
    Div({ classes(ElevationStyleSheet.box) }) {
        LargeBody("Level 3")
        Elevation(3)
    }
    Div({ classes(ElevationStyleSheet.box) }) {
        LargeBody("Level 4")
        Elevation(4)
    }
}
