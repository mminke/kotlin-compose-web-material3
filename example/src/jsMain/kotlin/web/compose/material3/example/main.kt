import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import org.jetbrains.compose.web.css.padding
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.H1
import org.jetbrains.compose.web.dom.H2
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.compose.web.renderComposable
import web.compose.extras.Column
import web.compose.extras.Row
import web.compose.material3.buttons.ElevatedButton
import web.compose.material3.buttons.FilledButton
import web.compose.material3.buttons.OutlinedButton
import web.compose.material3.buttons.TextButton
import web.compose.material3.buttons.TonalButton
import web.compose.material3.buttons.label
import web.compose.material3.icon.DataVariant
import web.compose.material3.icon.Icon
import web.compose.material3.icon.Slot
import web.compose.material3.icon.dataVariant
import web.compose.material3.icon.slot
import web.compose.material3.navigationbar.NavigationBar
import web.compose.material3.textfield.FilledTextField
import web.compose.material3.textfield.OutlinedTextField
import web.compose.material3.textfield.label
import web.compose.material3.textfield.onInput
import web.compose.material3.textfield.value

external fun require(module: String): dynamic

fun main() {
    require("@material/web/button/filled-button.js")
    require("@material/web/button/outlined-button.js")
    require("@material/web/button/elevated-button.js")
    require("@material/web/button/text-button.js")
    require("@material/web/button/tonal-button.js")
    require("@material/web/navigationbar/navigation-bar.js")
    require("@material/web/textfield/outlined-text-field.js")
    require("@material/web/textfield/filled-text-field.js")
    require("@material/web/list/list.js")
    require("@material/web/list/list-item.js")
    require("@material/web/icon/icon.js")

    renderComposable(rootElementId = "root") {
        var textFieldValue by remember { mutableStateOf<String>("Initial text field value") }

        Column {
            // Column / Row concept ?!?!?
            H1 { Text("Kotlin HTML - Material Design 3 Web Components Examples") }

            Column {
                H2 { Text("Navigation Bar") }
                Row {
                    NavigationBar {}
                }
            }

            Row {
                Column {
                    H2 { Text("Buttons") }

                    FilledButton({
                        label = "Filled Button"; onClick {
                        textFieldValue = "filled button clicked"
                    }; style { padding(5.px) }
                    })
                    OutlinedButton({
                        label = "Outlined Button"; onClick {
                        textFieldValue = "outlined button clicked"
                    }; style { padding(5.px) }
                    })
                    ElevatedButton({
                        label = "Eevated Button"; onClick {
                        textFieldValue = "elevated button clicked"
                    }; style { padding(5.px) }
                    })
                    TextButton({
                        label = "Text Button"; onClick {
                        textFieldValue = "text button clicked"
                    }; style { padding(5.px) }
                    })
                    TonalButton({
                        label = "Tonal Button"; onClick {
                        textFieldValue = "tonal button clicked"
                    }; style { padding(5.px) }
                    })
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

                    OutlinedTextField({
                        label = "Outlined Text Field"
                        value = textFieldValue
                        onInput {
                            textFieldValue = it.value ?: ""
                        }
                        style { padding(5.px) }
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
            }


        }
    }
}
