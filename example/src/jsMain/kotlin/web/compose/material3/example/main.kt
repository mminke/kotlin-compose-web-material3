package web.compose.material3.example

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import org.jetbrains.compose.web.attributes.rows
import org.jetbrains.compose.web.css.Style
import org.jetbrains.compose.web.css.StyleSheet
import org.jetbrains.compose.web.css.fontSize
import org.jetbrains.compose.web.css.height
import org.jetbrains.compose.web.css.padding
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.H1
import org.jetbrains.compose.web.dom.H3
import org.jetbrains.compose.web.dom.Label
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.compose.web.dom.TextArea
import org.jetbrains.compose.web.renderComposable
import org.w3c.files.File
import web.compose.extras.Column
import web.compose.extras.Row
import web.compose.extras.fileupload.FilledFileInput
import web.compose.extras.fileupload.OutlinedFileDragDropArea
import web.compose.material3.ColorScheme
import web.compose.material3.MaterialTheme
import web.compose.material3.badge.Badge
import web.compose.material3.badge.value
import web.compose.material3.buttons.ElevatedButton
import web.compose.material3.buttons.FilledButton
import web.compose.material3.buttons.OutlinedButton
import web.compose.material3.buttons.TextButton
import web.compose.material3.buttons.TonalButton
import web.compose.material3.checkbox.Checkbox
import web.compose.material3.checkbox.checked
import web.compose.material3.dialog.Dialog
import web.compose.material3.dialog.onCancel
import web.compose.material3.dialog.onClose
import web.compose.material3.dialog.open
import web.compose.material3.disabled
import web.compose.material3.divider.Divider
import web.compose.material3.fab.Fab
import web.compose.material3.fab.FabSize.LARGE
import web.compose.material3.fab.FabSize.SMALL
import web.compose.material3.fab.label
import web.compose.material3.fab.size
import web.compose.material3.field.FilledField
import web.compose.material3.field.OutlinedField
import web.compose.material3.field.error
import web.compose.material3.field.errorText
import web.compose.material3.field.label
import web.compose.material3.field.value
import web.compose.material3.icon.Icon
import web.compose.material3.iconbutton.FilledIconButton
import web.compose.material3.iconbutton.OutlinedIconButton
import web.compose.material3.iconbutton.StandardIconButton
import web.compose.material3.iconbutton.TonalIconButton
import web.compose.material3.iconbutton.selected
import web.compose.material3.iconbutton.toggle
import web.compose.material3.list.List
import web.compose.material3.list.ListItem
import web.compose.material3.list.headline
import web.compose.material3.list.supportingText
import web.compose.material3.navigationdrawer.NavigationDrawer
import web.compose.material3.onChange
import web.compose.material3.progress.CircularProgress
import web.compose.material3.progress.LinearProgress
import web.compose.material3.progress.Progress
import web.compose.material3.progress.fourColor
import web.compose.material3.progress.indeterminate
import web.compose.material3.progress.progress
import web.compose.material3.radio.Radio
import web.compose.material3.radio.checked
import web.compose.material3.radio.name
import web.compose.material3.radio.value
import web.compose.material3.select.FilledSelect
import web.compose.material3.select.OutlinedSelect
import web.compose.material3.select.SelectOption
import web.compose.material3.select.headline
import web.compose.material3.select.label
import web.compose.material3.select.onChange
import web.compose.material3.select.supportingText
import web.compose.material3.select.value
import web.compose.material3.slider.Slider
import web.compose.material3.slider.max
import web.compose.material3.slider.min
import web.compose.material3.slider.step
import web.compose.material3.slider.value
import web.compose.material3.slider.withLabel
import web.compose.material3.slot
import web.compose.material3.switch.Switch
import web.compose.material3.switch.selected
import web.compose.material3.textfield.FilledTextField
import web.compose.material3.textfield.OutlinedTextField
import web.compose.material3.textfield.TextFieldType.EMAIL
import web.compose.material3.textfield.TextFieldType.NUMBER
import web.compose.material3.textfield.TextFieldType.PASSWORD
import web.compose.material3.textfield.TextFieldType.SEARCH
import web.compose.material3.textfield.TextFieldType.URL
import web.compose.material3.textfield.error
import web.compose.material3.textfield.errorText
import web.compose.material3.textfield.label
import web.compose.material3.textfield.onInput
import web.compose.material3.textfield.required
import web.compose.material3.textfield.type
import web.compose.material3.textfield.value
import web.compose.material3.themes.defaultColorScheme
import web.compose.material3.themes.defaultDarkColorScheme

data class ListDataItem(
    val name: String, val organisation: String
)

val listData = listOf(
    ListDataItem("John Doe", "Example.org"),
    ListDataItem("Jane Doe", "Another.example.org")
)


fun main() {
    renderComposable(rootElementId = "root") {

        MaterialThemeExamples()

    }
}

@Composable
fun MaterialThemeExamples() {
    var textFieldValue by remember { mutableStateOf("Initial text field value") }
    var checkboxStatus by remember { mutableStateOf(false) }
    val lightColorScheme = defaultColorScheme
    val darkColorScheme = defaultDarkColorScheme
    var currentColorScheme by remember { mutableStateOf<ColorScheme?>(lightColorScheme) }

    MaterialTheme(currentColorScheme) {

        H1 { Text("Kotlin HTML - Material Design theme 3 Web Components Examples") }

        P {
            Text(
                """
                This pages shows examples of the Material Design 3 Components in Kotlin which wrap the web components 
                being developed at 
            """.trimIndent()
            )
            A(href = "https://github.com/material-components/material-web") { Text("https://github.com/material-components/material-web") }
        }

        WidgetGroup("Stable widgets") {
            P { Text("No stable widgets yet") }
        }

        WidgetGroup("Beta widgets") {
            Column {
                H3 { Text("Divider") }

                Divider()

                H3 { Text("Fields") }

                FilledField({
                }) {
                    TextArea(value = "Text area inside a filled field", { rows(5) })
                }

                OutlinedField({
                    label = "An outlined field label"
                    value = "Field value"
                }) {
                    P { Text("Some text") }
                }
                OutlinedField({
                    error()
                    errorText = "An error occured"
                    label = "An outlined field label"
                    value = "Field value"
                }) {
                    P { Text("Some text") }
                }
            }

            Column {
                H3 { Text("Buttons") }

                FilledButton({
                    onClick { textFieldValue = "filled button clicked" }
                    style { padding(5.px) }
                }) { Text("Filled Button") }
                OutlinedButton({
                    onClick { textFieldValue = "outlined button clicked" }
                    style { padding(5.px) }
                }) { Text("Outlined Button") }
                ElevatedButton({
                    onClick { textFieldValue = "elevated button clicked" }
                    style { padding(5.px) }
                }) { Text("Elevated Button") }
                TextButton({
                    onClick { textFieldValue = "text button clicked" }
                    style { padding(5.px) }
                }) { Text("Text Button") }
                TonalButton({
                    onClick { textFieldValue = "tonal button clicked" }
                    style { padding(5.px) }
                }) { Text("Tonal Button") }

                H3 { Text("FAB") }
                Fab({ size = SMALL }) {
                    Icon({ slot = "icon" }) { Text("edit") }
                }
                Fab {
                    Icon({ slot = "icon" }) { Text("delete") }
                }
                Fab({ size = LARGE }) {
                    Icon({ slot = "icon" }) { Text("add") }
                }
                Fab({ label = "FAB" })
            }

            Column {
                H3 { Text("Icon Buttons") }
                var toggleButtonSelected by remember { mutableStateOf(false) }

                FilledIconButton({
                    onClick { textFieldValue = "filled icon button clicked" }
                    style { padding(5.px) }
                }) {
                    Text("star")
                }
                OutlinedIconButton({
                    onClick { textFieldValue = "outlined icon button clicked" }
                    style { padding(5.px) }
                }) { Text("login") }
                TonalIconButton({
                    onClick { textFieldValue = "tonal icon button clicked" }
                    style { padding(5.px) }
                }) { Text("public") }
                StandardIconButton({
                    onClick { toggleButtonSelected = !toggleButtonSelected }
                    style { padding(5.px) }
                }) { Text("menu") }
                FilledIconButton({
                    toggle()
                    selected(toggleButtonSelected)
                    style { padding(5.px) }
                }) {
                    Icon({ slot = "onIcon" }) { Text("lock") }
                    Icon({ slot = "offIcon" }) { Text("lock_open") }
                }
            }

            Column {
                H3 { Text("Dialog") }
                var dialogOpen by remember { mutableStateOf(true) }

                OutlinedButton({
                    onClick {
                        console.log("Toggle dialog")
                        dialogOpen = !dialogOpen
                    }
                }) { Text("Open dialog") }
                Dialog({
                    open(dialogOpen)
                    onClose {
                        console.log("Closing dialog")
                        dialogOpen = false
                    }
                    onCancel {
                        console.log("Cancel dialog")
                        dialogOpen = false
                    }
                }) {
                    Span({ slot = "headline" }) { Text("Dialog") }
                    Divider()
                    OutlinedButton({ slot = "footer"; onClick { dialogOpen = false } }) { Text("Close") }
                }
            }

            Column {
                H3 { Text("Text Fields") }

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
                    disabled()
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
                    value = "Welcome"
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
            }

            Column {
                H3 { Text("Misc ") }

                H3 { Text("Icons") }
                Row {
                    Icon({ slot = "start" }) { Text("edit") }
                    Icon({ slot = "start" }) { Text("delete") }
                    Icon({ slot = "end" }) { Text("close") }
                }

                H3 { Text("Progress Indicators") }

                Div({ style { height(25.px) } }) {
                    LinearProgress({
                        progress = Progress(0.3f)
                    })
                }
                Div({ style { height(25.px) } }) {
                    LinearProgress({
                        indeterminate()
                        fourColor()
                    })
                }
                Div {
                    CircularProgress({
                        progress = Progress(0.7f)
                    })
                }
                Div {
                    CircularProgress({
                        indeterminate()
                        fourColor()
                    })
                }

                H3 { Text("Badges") }

                Row {
                    TonalIconButton({
                        onClick { textFieldValue = "tonal icon button clicked" }
                        style { padding(5.px) }
                    }) {
                        Text("public")
                        Badge()
                    }

                    TonalIconButton({
                        onClick { textFieldValue = "tonal icon button clicked" }
                        style { padding(5.px) }
                    }) {
                        Text("public")
                        Badge({ value = "1" })
                    }

                    TonalIconButton({
                        onClick { textFieldValue = "tonal icon button clicked" }
                        style { padding(5.px) }
                    }) {
                        Text("public")
                        Badge({ value = "999+" })
                    }
                }
                H3 { Text("Checkbox") }
                Checkbox({
                    checked(checkboxStatus)
                    onClick {
                        checkboxStatus = !checkboxStatus
                    }
                })
                Checkbox({
                    checked(checkboxStatus)
                    onClick {
                        checkboxStatus = !checkboxStatus
                    }
                    disabled()
                })

                H3 { Text("Switch") }
                Switch({
                    selected(checkboxStatus)
                    onClick { checkboxStatus = !checkboxStatus }
                })
                Switch({
                    selected(checkboxStatus)
                    onClick { checkboxStatus = !checkboxStatus }
                    disabled()
                })

                H3 { Text("Slider") }
                var sliderValue by remember { mutableStateOf(0L) }
                Slider({
                    min = 100
                    max = 200
                    step = 2
                    value = sliderValue
                    withLabel()
                    onChange { sliderValue = it.currentTarget.asDynamic().value }
                }) { }
                Slider({
                    min = 100
                    max = 200
                    step = 2
                    value = sliderValue
                    withLabel()
                    disabled()
                }) { }

                H3 { Text("Radio") }
                var radioValue by remember { mutableStateOf<String?>(null) }
                Row {
                    Radio({
                        id("r1")
                        name = "radio-group"
                        value = "o1"
                        checked(radioValue == "o1")
                        onChange { radioValue = "o1" }
                    })
                    Label("r1") { Text("Option 1") }
                }
                Row {
                    Radio({
                        id("r2")
                        name = "radio-group"
                        value = "o2"
                        checked(radioValue == "o2")
                        onChange { radioValue = "o2" }
                    })
                    Label("r2") { Text("Option 2") }
                }
                Row {
                    Radio({
                        id("r3")
                        name = "radio-group"
                        value = "o3"
                        checked(radioValue == "o3")
                        onChange { radioValue = "o3" }
                    })
                    Label("r3") { Text("Option 3") }
                }
                Row {
                    Radio({
                        id("r4")
                        name = "radio-group"
                        value = "o4"
                        disabled()
                        checked(radioValue == "o4")
                        onChange { radioValue = "o4" }
                    })
                    Label("r4") { Text("Option 4") }
                }
                P { Text("Radio button selected: $radioValue") }

                H3 { Text("Select") }
                var selectedValue by remember { mutableStateOf("") }

                FilledSelect({
                    label = "Select label"
                    supportingText = "Selected value $selectedValue"
                    onChange {
                        selectedValue = it.currentTarget?.asDynamic()?.value ?: ""
                    }
                }) {
                    SelectOption { }
                    SelectOption({ value = "MD1"; headline = "Material Design 1" })
                    SelectOption({ value = "MD2"; headline = "Material Design 2" })
                    SelectOption({ value = "MD3"; headline = "Material Design 3" })
                }

                OutlinedSelect({
                    label = "Select label"
                    supportingText = "Selected value $selectedValue"
                    onChange {
                        selectedValue = it.currentTarget?.asDynamic()?.value ?: ""
                    }
                }) {
                    SelectOption { }
                    SelectOption({ value = "MD1"; headline = "Material Design 1" })
                    SelectOption({ value = "MD2"; headline = "Material Design 2" })
                    SelectOption({ value = "MD3"; headline = "Material Design 3" })
                }
            }

            Column {
                H3 { Text("List box") }
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

        WidgetGroup("Alpha widgets") {
            Column {
                H3 { Text("Navigation Drawer") }

                NavigationDrawer {
                    Text("Navigation drawer")
                }
            }
        }

        WidgetGroup("Extra components") {
            var selectedFiles by remember { mutableStateOf<List<File>>(emptyList()) }
            Column {
                H3 { Text("File input button") }
                FilledFileInput({
                    if (it == null) return@FilledFileInput
                    selectedFiles = it
                }) { Text("Upload files...") }

                FileList(selectedFiles)
            }
            Column {
                H3 { Text("File drag/drop area") }

                OutlinedFileDragDropArea(
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

        ExampleNavigationBar(currentColorScheme, lightColorScheme, darkColorScheme) {
            currentColorScheme = it
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
