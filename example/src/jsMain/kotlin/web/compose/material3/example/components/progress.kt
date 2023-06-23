package web.compose.material3.example.components

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.css.height
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Div
import web.compose.extras.text.LargeTitle
import web.compose.material3.progress.*

@Composable
fun ProgressIndicatorShowcase() {
    LargeTitle("Progress Indicators")

    Div({ style { height(25.px) } }) {
        LinearProgress({
            progress = Progress(0.3f)
        })
    }
    Div({ style { height(25.px) } }) {
        LinearProgress({
            indeterminate()
            fourColor()
        })
    }
    Div {
        CircularProgress({
            progress = Progress(0.7f)
        })
    }
    Div {
        CircularProgress({
            indeterminate()
            fourColor()
        })
    }
}
