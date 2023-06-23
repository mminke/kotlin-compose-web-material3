package web.compose.material3.example.components

import androidx.compose.runtime.*
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text
import web.compose.extras.text.LargeTitle
import web.compose.material3.buttons.OutlinedButton
import web.compose.material3.dialog.Dialog
import web.compose.material3.dialog.onClosed
import web.compose.material3.dialog.onClosing
import web.compose.material3.dialog.open
import web.compose.material3.divider.Divider
import web.compose.material3.slot

@Composable
fun DialogShowcase() {
    LargeTitle("Dialog")
    var dialogOpen by remember { mutableStateOf(false) }
    var dialogClosing by remember { mutableStateOf(false) }

    OutlinedButton({
        onClick {
            dialogOpen = !dialogOpen
        }
    }) { Text("Open dialog") }

    if (dialogOpen || dialogClosing) {
        Dialog({
            open(dialogOpen&&!dialogClosing)
            onClosed {
                dialogOpen = false
                dialogClosing = false
            }
            onClosing {
                dialogClosing = true
            }
        }) {
            Span({ slot = "headline" }) { Text("Dialog") }
            Divider()
            OutlinedButton({
                slot = "footer"
                onClick {
                    console.log(it)
                    dialogClosing = true
                }
            }) { Text("Close") }
        }
    }
}
