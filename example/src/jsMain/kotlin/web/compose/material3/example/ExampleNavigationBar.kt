package web.compose.material3.example

import androidx.compose.runtime.Composable
import web.compose.extras.BottomNavigationBar
import web.compose.material3.fab.Fab
import web.compose.material3.icon.Icon
import web.compose.material3.navigationtab.NavigationTab
import web.compose.material3.navigationtab.label
import web.compose.material3.slot

@Composable
fun ExampleNavigationBar() {
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
        Fab { Icon({ slot = "icon" }, "add") }
    }
}
