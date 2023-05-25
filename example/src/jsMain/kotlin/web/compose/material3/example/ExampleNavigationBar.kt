package web.compose.material3.example

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.css.*
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
            Icon({ slot = "activeIcon" }) { Text("home") }
            Icon({ slot = "inactiveIcon" }) { Text("home") }
        }
        NavigationTab({ label = "Explore" }) {
            Icon({ slot = "activeIcon" }) { Text("public") }
            Icon({ slot = "inactiveIcon" }) { Text("public") }
        }
        NavigationTab({ label = "Edit" }) {
            Icon({ slot = "activeIcon" }) { Text("edit_note") }
            Icon({ slot = "inactiveIcon" }) { Text("edit_note") }
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
