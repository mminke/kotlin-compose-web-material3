package web.compose.material3.example

import androidx.compose.runtime.*
import org.jetbrains.compose.web.attributes.rows
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.css.JustifyContent.Companion.SpaceEvenly
import org.jetbrains.compose.web.dom.*
import org.jetbrains.compose.web.renderComposable
import org.w3c.files.File
import web.compose.extras.Column
import web.compose.extras.Row
import web.compose.extras.fileupload.FilledFileInput
import web.compose.extras.fileupload.OutlinedFileDragDropArea
import web.compose.extras.text.*
import web.compose.material3.badge.Badge
import web.compose.material3.badge.value
import web.compose.material3.buttons.*
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
import web.compose.material3.field.*
import web.compose.material3.icon.Icon
import web.compose.material3.iconbutton.*
import web.compose.material3.list.List
import web.compose.material3.list.ListItem
import web.compose.material3.list.headline
import web.compose.material3.list.supportingText
import web.compose.material3.navigationdrawer.NavigationDrawer
import web.compose.material3.onChange
import web.compose.material3.progress.*
import web.compose.material3.radio.Radio
import web.compose.material3.radio.checked
import web.compose.material3.radio.name
import web.compose.material3.radio.value
import web.compose.material3.select.*
import web.compose.material3.select.onChange
import web.compose.material3.slider.*
import web.compose.material3.slot
import web.compose.material3.switch.Switch
import web.compose.material3.switch.selected
import web.compose.material3.textfield.*
import web.compose.material3.textfield.TextFieldType.*
import web.compose.material3.themes.defaultColorScheme
import web.compose.material3.themes.defaultDarkColorScheme
import web.compose.material3.theming.MaterialTheme
import web.compose.material3.theming.SysColorScheme
import web.compose.material3.theming.SysFontScheme

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
    var currentColorScheme by remember { mutableStateOf<SysColorScheme?>(lightColorScheme) }

    MaterialTheme(currentColorScheme, SysFontScheme()) {

        LargeDisplay("Kotlin HTML - Material Design 3 Web Components Examples")

        LargeBody {
            Text(
                """
                This pages shows examples of the Material Design 3 Components in Kotlin which wrap the web components 
                being developed at 
            """.trimIndent()
            )

            A(href = "https://github.com/material-components/material-web") { Text("https://github.com/material-components/material-web") }
        }

        WidgetGroup("Stable widgets") {
            LargeBody("No stable widgets yet")
        }

        WidgetGroup("Beta widgets") {
            Column {
                Row {
                    Column {
                        LargeTitle("Divider")

                        Divider()

                        LargeTitle("Fields")

                        FilledField({
                        }) {
                            TextArea(value = "Text area inside a filled field", { rows(5) })
                        }

                        OutlinedField({
                            label = "An outlined field label"
                            value = "Field value"
                        }) {
                            LargeBody("Some text")
                        }
                        OutlinedField({
                            error()
                            errorText = "An error occured"
                            label = "An outlined field label"
                            value = "Field value"
                        }) {
                            LargeBody("Some text")
                        }
                    }

                    Column {
                        LargeTitle("Buttons")

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

                        LargeTitle("FAB")
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
                        LargeTitle("Icon Buttons")
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
                        LargeTitle("Dialog")
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
                        LargeTitle("Text Fields")

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
                        LargeTitle("Misc ")

                        LargeTitle("Icons")
                        Row {
                            Icon({ slot = "start" }) { Text("edit") }
                            Icon({ slot = "start" }) { Text("delete") }
                            Icon({ slot = "end" }) { Text("close") }
                        }

                        LargeTitle("Progress Indicators")

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

                        LargeTitle("Badges")

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
                        LargeTitle("Checkbox")
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

                        LargeTitle("Switch")
                        Switch({
                            selected(checkboxStatus)
                            onClick { checkboxStatus = !checkboxStatus }
                        })
                        Switch({
                            selected(checkboxStatus)
                            onClick { checkboxStatus = !checkboxStatus }
                            disabled()
                        })

                        LargeTitle("Slider")
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

                        LargeTitle("Radio")
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
                        LargeBody("Radio button selected: $radioValue")

                        LargeTitle("Select")
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
                        LargeTitle("List box")
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
                    LargeTitle("Typography")
                    Row({ style { justifyContent(SpaceEvenly) } }) {
                        Column {
                            LargeDisplay("Large Display")
                            LargeHeadline("Large Headline")
                            LargeTitle("Large Title")
                            LargeBody("Large Body")
                            LargeLabel("Large Label")
                        }
                        Column {
                            MediumDisplay("Medium Display")
                            MediumHeadline("Medium Headline")
                            MediumTitle("Medium Title")
                            MediumBody("Medium Body")
                            MediumLabel("Medium Label")
                        }
                        Column {
                            SmallDisplay("Small Display")
                            SmallHeadline("Small Headline")
                            SmallTitle("Small Title")
                            SmallBody("Small Body")
                            SmallLabel("Small Label")
                        }
                    }
                }
            }
        }

        WidgetGroup("Alpha widgets") {
            Column {
                LargeTitle("Navigation Drawer")

                NavigationDrawer {
                    Text("Navigation drawer")
                }
            }
        }

        WidgetGroup("Extra components") {
            var selectedFiles by remember { mutableStateOf<List<File>>(emptyList()) }
            Column {
                LargeTitle("File input button")
                FilledFileInput({
                    if (it == null) return@FilledFileInput
                    selectedFiles = it
                }) { Text("Upload files...") }

                FileList(selectedFiles)
            }
            Column {
                LargeTitle("File drag/drop area")

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
