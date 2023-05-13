package web.compose.material3.example

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.border
import org.jetbrains.compose.web.css.color
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.style
import org.jetbrains.compose.web.css.width
import org.jetbrains.compose.web.dom.H2
import org.jetbrains.compose.web.dom.Text
import web.compose.extras.Column
import web.compose.extras.Row

@Composable
fun WidgetGroup(title: String, content: @Composable () -> Unit) {
    Column {
        H2 { Text(title) }

        Row({ style { border { style(LineStyle.Dotted); width(2.px); color(Color.lightgray) } } }) {
            content()
        }
    }
}