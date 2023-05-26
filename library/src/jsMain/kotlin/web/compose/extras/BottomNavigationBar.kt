package web.compose.extras

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.Style
import org.jetbrains.compose.web.css.StyleSheet
import org.jetbrains.compose.web.css.backgroundColor
import org.jetbrains.compose.web.css.bottom
import org.jetbrains.compose.web.css.left
import org.jetbrains.compose.web.css.paddingBottom
import org.jetbrains.compose.web.css.position
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import web.compose.material3.navigationbar.NavigationBar
import web.compose.material3.navigationbar.NavigationBarElement

@Composable
fun BottomNavigationBar(
    attrs: AttrBuilderContext<NavigationBarElement>? = null,
    content: ContentBuilder<NavigationBarElement>? = null
) {
    Style(StyleSheet().apply {
        root style {
            paddingBottom(80.px)
        }
    })
    NavigationBar({
        style {
            position(Position.Fixed)
            left(0.px)
            bottom(0.px)
            property("z-index", 99999)
            backgroundColor(Color.red)
        }
        if (attrs != null) {
            this.attrs()
        }
    }, content)
}