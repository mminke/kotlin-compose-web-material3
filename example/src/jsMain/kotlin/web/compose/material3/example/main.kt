import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import org.jetbrains.compose.web.css.Style
import org.jetbrains.compose.web.css.StyleSheet
import org.jetbrains.compose.web.css.fontSize
import org.jetbrains.compose.web.css.height
import org.jetbrains.compose.web.css.padding
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.H1
import org.jetbrains.compose.web.dom.H2
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.compose.web.renderComposable
import org.w3c.files.File
import web.compose.extras.Column
import web.compose.extras.Row
import web.compose.extras.fileupload.FileDragDropArea
import web.compose.extras.fileupload.FilledFileInput
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
import kotlin.math.roundToInt

data class ListDataItem(
    val name: String, val organisation: String
)

val listData = listOf(
    ListDataItem("John Doe", "Example.org"),
    ListDataItem("Jane Doe", "Another.example.org")
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

//                    OutlinedTextField({
//                        label = "Multiline textfield"
//                        value = "This does not work yet!?!"
//                        style { padding(5.px); height(100.px) }
//                    })
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

            Column {
                H1 { Text("Extra components") }

                Row {
                    var selectedFiles by remember { mutableStateOf<List<File>>(emptyList()) }
                    Column {
                        H2 { Text("File input button") }
                        FilledFileInput("Upload files...") {
                            if (it == null) return@FilledFileInput
                            selectedFiles = it
                        }

                        FileList(selectedFiles)
                    }
                    Column {
                        H2 { Text("File drag/drop area") }

                        FileDragDropArea(
                            onDrop = { list ->
                                selectedFiles = list
                            }
                        ) {
                            if (selectedFiles.isEmpty())
                                Text("Drag & drop files here!")
                            else
                                FileListInfo(selectedFiles)
                        }
                    }
                }
            }
        }
    }
}

object FileListStyleSheet : StyleSheet() {
    val filelist by style {
        "Div" style {
            fontSize(12.px)
        }
        self + hover style {
        }
    }
}

@Composable
fun FileList(files: List<File>) {
    Style(FileListStyleSheet)
    Column({ classes(FileListStyleSheet.filelist) }) {
        files.forEach {
            Div {
                Text("Filename: ${it.name} [${it.size}, ${it.type}], ${it.lastModified}")
            }
        }
    }
}

@Composable
fun FileListInfo(files: List<File>) {
    val totalFileSize = files.sumOf { it.size.toInt() }
    Div { Text("Number of files: ${files.size}") }
    Div { Text("Total amount of bytes: ${formatBytes(totalFileSize)}") }
}


/**
 * This generates formatting functions for applying aggregating units (e.g. Kilo, Mega)
 * to values.  If you run out of units it gives up and shows the unit value.
 * NB This method is usable verbatim in Kotlin/JS.
 *
 * @param base The unit base, e.g. 1024 for bytes, 1000 for metric units of measure.
 * @param units the names of the units starting with the base unit (e.g. byte, meter).
 */
fun formatUnits(base: Int, units: List<String>): (Double, Int) -> String {
    check(1 < base)
    check(units.isNotEmpty())
    return { value, precision ->
        check(0 <= precision)
        tailrec fun haveAtIt(unitsTail: List<String>, adj: Double): String {
            if (unitsTail.isEmpty()) {
                return "$value${units.first()}"
            }
            if (adj < base) {
                val formatter: Double = precision.let {
                    var i = 1.0
                    for (q in 0 until precision)
                        i *= 10.0
                    i
                }
                val mag = ((adj * formatter).roundToInt() / formatter).toString().let {
                    if (it.endsWith(".0")) it.substring(0..it.length - 3)
                    else it
                }
                return "$mag${unitsTail.first()}"
            }
            return haveAtIt(unitsTail.drop(1), adj / base)
        }
        haveAtIt(units, value)
    }
}

private val formatBytesImpl = formatUnits(1024, listOf("B", "KB", "MB", "GB", "TB", "PB", "EB", "ZB", "YB"))
fun formatBytes(bytes: Int): String = formatBytesImpl(bytes.toDouble(), 2)
