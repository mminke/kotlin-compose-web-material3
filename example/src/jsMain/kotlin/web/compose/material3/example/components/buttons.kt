package web.compose.material3.example.components

import androidx.compose.runtime.*
import org.jetbrains.compose.web.dom.Text
import web.compose.extras.text.LargeLabel
import web.compose.extras.text.LargeTitle
import web.compose.material3.buttons.*
import web.compose.material3.fab.Fab
import web.compose.material3.fab.FabSize
import web.compose.material3.fab.label
import web.compose.material3.fab.size
import web.compose.material3.icon.Icon
import web.compose.material3.slot

@Composable
fun ButtonShowcase() {
    var clickedValue by remember { mutableStateOf("<<No button clicked>>") }

    LargeTitle("Buttons")

    LargeLabel("Button clicked: $clickedValue")

    FilledButton({ onClick { clickedValue = "filled button clicked" } }) { Text("Filled Button") }
    OutlinedButton({ onClick { clickedValue = "outlined button clicked" } }) { Text("Outlined Button") }
    ElevatedButton({ onClick { clickedValue = "elevated button clicked" } }) { Text("Elevated Button") }
    TextButton({ onClick { clickedValue = "text button clicked" } }) { Text("Text Button") }
    TonalButton({ onClick { clickedValue = "tonal button clicked" } }) { Text("Tonal Button") }

    LargeTitle("FAB")
    Fab({ size = FabSize.SMALL; onClick { clickedValue = "Small FAB clicked" } }) {
        Icon({ slot = "icon" }, "edit")
    }
    Fab({ size = FabSize.MEDIUM; onClick { clickedValue = "Medium FAB clicked" } }) {
        Icon({ slot = "icon" }, "delete")
    }
    Fab({ size = FabSize.LARGE; onClick { clickedValue = "Large FAB clicked" } }) {
        Icon({ slot = "icon" }, "add")
    }
    Fab({ label = "FAB"; onClick { clickedValue = "FAB with label clicked" } })
}
