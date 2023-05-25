package web.compose.material3.example

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.css.*
import web.compose.extras.Column
import web.compose.extras.Row
import web.compose.extras.text.LargeHeadline

@Composable
fun WidgetGroup(title: String, content: @Composable () -> Unit) {
    Column {
        LargeHeadline(title)

        Row({ style { border { style(LineStyle.Dotted); width(2.px); color(Color.lightgray) } } }) {
            content()
        }
    }
}
