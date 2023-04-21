import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import org.jetbrains.compose.web.css.height
import org.jetbrains.compose.web.css.padding
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.H1
import org.jetbrains.compose.web.dom.H2
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.compose.web.renderComposable
import web.compose.extras.Column
import web.compose.extras.Row
import web.compose.material3.MaterialTheme
import web.compose.material3.buttons.ElevatedButton
import web.compose.material3.buttons.FilledButton
import web.compose.material3.buttons.OutlinedButton
import web.compose.material3.buttons.TextButton
import web.compose.material3.buttons.TonalButton
import web.compose.material3.buttons.label
import web.compose.material3.fab.Fab
import web.compose.material3.fab.FabSize.LARGE
import web.compose.material3.fab.FabSize.SMALL
import web.compose.material3.fab.size
import web.compose.material3.icon.DataVariant
import web.compose.material3.icon.Icon
import web.compose.material3.icon.Slot
import web.compose.material3.icon.Slot.ICON
import web.compose.material3.icon.dataVariant
import web.compose.material3.icon.slot
import web.compose.material3.list.List
import web.compose.material3.list.ListItem
import web.compose.material3.list.headline
import web.compose.material3.list.supportingText
import web.compose.material3.navigationbar.NavigationBar
import web.compose.material3.textfield.FilledTextField
import web.compose.material3.textfield.OutlinedTextField
import web.compose.material3.textfield.TextFieldType.EMAIL
import web.compose.material3.textfield.TextFieldType.NUMBER
import web.compose.material3.textfield.TextFieldType.PASSWORD
import web.compose.material3.textfield.TextFieldType.SEARCH
import web.compose.material3.textfield.TextFieldType.URL
import web.compose.material3.textfield.disabled
import web.compose.material3.textfield.error
import web.compose.material3.textfield.errorText
import web.compose.material3.textfield.label
import web.compose.material3.textfield.onInput
import web.compose.material3.textfield.required
import web.compose.material3.textfield.type
import web.compose.material3.textfield.value

data class ListDataItem(
    val name: String, val organisation: String
)

val listData = listOf(
    ListDataItem("John Doe", "Example.org"), ListDataItem("Jane Doe", "Another.example.org")
)

fun main() {

    renderComposable(rootElementId = "root") {
        var textFieldValue by remember { mutableStateOf<String>("Initial text field value") }

        MaterialTheme {
            Column {
                // Column / Row concept ?!?!?
                H1 { Text("Kotlin HTML - Material Design theme 3 Web Components Examples") }

                Column {
                    H2 { Text("Navigation Bar") }
                    Row {
                        NavigationBar {}
                    }
                }
            }
            Row {
                Column {
                    H2 { Text("Buttons") }

                    FilledButton({
                        label = "Filled Button"
                        onClick { textFieldValue = "filled button clicked" }
                        style { padding(5.px) }
                    })
                    OutlinedButton({
                        label = "Outlined Button"
                        onClick { textFieldValue = "outlined button clicked" }
                        style { padding(5.px) }
                    })
                    ElevatedButton({
                        label = "Elevated Button"
                        onClick { textFieldValue = "elevated button clicked" }
                        style { padding(5.px) }
                    })
                    TextButton({
                        label = "Text Button"
                        onClick { textFieldValue = "text button clicked" }
                        style { padding(5.px) }
                    })
                    TonalButton({
                        label = "Tonal Button"
                        onClick { textFieldValue = "tonal button clicked" }
                        style { padding(5.px) }
                    })

                    H2 { Text("FAB") }
                    Fab({ size = SMALL }) {
                        Icon({ dataVariant = DataVariant.ICON; slot = ICON }) { Text("edit") }
                    }
                    Fab {
                        Icon({ dataVariant = DataVariant.ICON; slot = ICON }) { Text("delete") }
                    }
                    Fab({ size = LARGE }) {
                        Icon({ dataVariant = DataVariant.ICON; slot = ICON }) { Text("add") }
                    }
                    Fab({ label = "FAB" })
                }

                Column {
                    H2 { Text("Text Fields") }

                    FilledTextField({
                        label = "Filled Text Field"
                        value = textFieldValue
                        onInput {
                            textFieldValue = it.value ?: ""
                        }
                        style { padding(5.px) }
                    })

                    FilledTextField({
                        label = "Filled Text Field"
                        value = textFieldValue
                        disabled = true
                        style { padding(5.px) }
                    })

                    FilledTextField({
                        label = "Filled Text Field"
                        value = "Some input"
                        error = true
                        errorText = "No valid input"
                        style { padding(5.px) }
                    })

                    OutlinedTextField({
                        label = "Outlined Text Field"
                        value = textFieldValue
                        onInput {
                            textFieldValue = it.value ?: ""
                        }
                        style { padding(5.px) }
                    })

                    OutlinedTextField({
                        label = "Input a number"
                        value = "111"
                        type = NUMBER
                        required = true
                        style { padding(5.px) }
                    })

                    OutlinedTextField({
                        label = "Input a password"
                        value = "Welkom"
                        type = PASSWORD
                        style { padding(5.px) }
                    })

                    OutlinedTextField({
                        label = "Input an email"
                        value = "john.doe@example.com"
                        type = EMAIL
                        style { padding(5.px) }
                    })

                    OutlinedTextField({
                        label = "Input an url"
                        value = "https://www.example.com"
                        type = URL
                        style { padding(5.px) }
                    })

                    OutlinedTextField({
                        label = "Input an search"
                        value = "Some search?"
                        type = SEARCH
                        style { padding(5.px) }
                    })

                    OutlinedTextField({
                        label = "Multiline textfield"
                        value = "This does not work yet!?!\nunfortunately"
                        style { padding(5.px); height(400.px) }
                    })
                }

                Column {
                    H2 { Text("Misc") }

                    Row {
                        Text("Icons: ")
                        Icon({ dataVariant = DataVariant.ICON; slot = Slot.START }) { Text("edit") }
                        Icon({ dataVariant = DataVariant.ICON; slot = Slot.START }) { Text("delete") }
                        Icon({ dataVariant = DataVariant.ICON; slot = Slot.END }) { Text("close") }
                    }
                }

                Column {
                    H2 { Text("List box") }
                    List {
                        listData.forEach { listDateItem ->
                            ListItem({
                                headline = listDateItem.name
                                supportingText = listDateItem.organisation
                                onClick {
                                    textFieldValue = listDateItem.name
                                }
                            })
                        }
                    }
                }
            }
        }
    }
}

