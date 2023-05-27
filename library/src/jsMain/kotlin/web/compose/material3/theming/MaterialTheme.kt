package web.compose.material3.theming

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.Style
import org.jetbrains.compose.web.css.StyleSheet
import org.jetbrains.compose.web.css.backgroundColor
import org.jetbrains.compose.web.css.value

@Composable
fun MaterialTheme(
    colorScheme: SysColorScheme? = null,
    fontScheme: SysFontScheme?= null,
    content: @Composable () -> Unit) {
    if (colorScheme != null) {
        Style(colorScheme.asStylesheet())
    } else {
        Style(defaultBackground)
    }
    if (fontScheme != null) {
        Style(fontScheme.asStyleSheet())
    }

    content()
}

private object defaultBackground: StyleSheet() {
    init {
        root style {
            backgroundColor(MdSysColorVariables.mdSysColorSurfaceContainerLowest.value(Color("#FFFFFF")))
        }
    }
}