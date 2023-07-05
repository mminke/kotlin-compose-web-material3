package web.compose.material3.example.components

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Li
import org.jetbrains.compose.web.dom.Ul
import web.compose.extras.text.LargeLabel
import web.compose.extras.text.LargeTitle
import web.compose.material3.divider.Divider
import web.compose.material3.theming.MdSysColorVariables

object DividerStyleSheet : StyleSheet() {
    val list by style {
        border(1.px, LineStyle.Solid, MdSysColorVariables.mdSysColorOutline.value())
        margin(0.px)
        padding(0.px)
        width(200.px)
    }
    val listItem by style {
        color(MdSysColorVariables.mdSysColorOnBackground.value())
        fontFamily("system-ui")
        listStyle("none")
        margin(16.px)
    }
}

@Composable
fun DividerShowcase() {
    LargeTitle("Divider")

    Style(DividerStyleSheet)

    Ul({ classes(DividerStyleSheet.list) }) {
        Li({ classes(DividerStyleSheet.listItem) }) { LargeLabel("Default divider") }
        Divider()
        Li({ classes(DividerStyleSheet.listItem) }) { LargeLabel("Divider (inset = true)") }
        Divider(inset = true)
        Li({ classes(DividerStyleSheet.listItem) }) { LargeLabel("Divider (insetStart = true)") }
        Divider(insetStart = true)
        Li({ classes(DividerStyleSheet.listItem) }) { LargeLabel("Divider (insetEnd = true)") }
        Divider(insetEnd = true)
        Li({ classes(DividerStyleSheet.listItem) }) { LargeLabel("Final item") }
    }
}
