package web.compose.material3.theming

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.css.*

@Composable
fun MaterialTheme(colorScheme: ColorScheme? = null, content: @Composable () -> Unit) {
    if (colorScheme != null) {
        Style(colorScheme.asStylesheet())
    } else {
        Style(StyleSheet().apply {
            root style {
                backgroundColor(MdSysColorVariables.mdSysColorSurfaceContainerLowest.value(Color("#FFFFFF")))
            }
        })
    }

    content()
}
