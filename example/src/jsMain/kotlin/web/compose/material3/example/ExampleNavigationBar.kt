package web.compose.material3.example

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.css.AlignItems
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.JustifyContent
import org.jetbrains.compose.web.css.alignItems
import org.jetbrains.compose.web.css.display
import org.jetbrains.compose.web.css.gap
import org.jetbrains.compose.web.css.justifyContent
import org.jetbrains.compose.web.css.padding
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text
import web.compose.extras.BottomNavigationBar
import web.compose.material3.icon.Icon
import web.compose.material3.navigationtab.NavigationTab
import web.compose.material3.navigationtab.label
import web.compose.material3.slot
import web.compose.material3.switch.Switch
import web.compose.material3.switch.selected
import web.compose.material3.theming.SysColorScheme

@Composable
fun ExampleNavigationBar(
    currentColorScheme: SysColorScheme?,
    lightColorScheme: SysColorScheme,
    darkColorScheme: SysColorScheme,
    setCurrentColorScheme: (SysColorScheme) -> Unit,
) {

    BottomNavigationBar {
        NavigationTab({ label = "Home" }) {
            Icon({ slot = "activeIcon" }, "home")
            Icon({ slot = "inactiveIcon" }, "home")
        }
        NavigationTab({ label = "Explore" }) {
            Icon({ slot = "activeIcon" }, "public")
            Icon({ slot = "inactiveIcon" }, "public")
        }
        NavigationTab({ label = "Edit" }) {
            Icon({ slot = "activeIcon" }, "edit_note")
            Icon({ slot = "inactiveIcon" }, "edit_note")
        }

        Div({
            style {
                display(DisplayStyle.Flex)
                alignItems(AlignItems.Center)
                justifyContent(JustifyContent.Center)
                gap(10.px)
                padding(30.px)
            }
        }) {
            Text("Switch theme")
            Switch({
                selected(currentColorScheme != lightColorScheme)
                onClick {
                    setCurrentColorScheme(
                        if (currentColorScheme == lightColorScheme)
                            darkColorScheme
                        else
                            lightColorScheme
                    )
                }
            })
        }
    }
}
