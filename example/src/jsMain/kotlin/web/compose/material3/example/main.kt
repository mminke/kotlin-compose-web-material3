package web.compose.material3.example

import androidx.compose.runtime.*
import org.jetbrains.compose.web.attributes.TextAreaWrap
import org.jetbrains.compose.web.attributes.rows
import org.jetbrains.compose.web.attributes.wrap
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.css.DisplayStyle.Companion.Flex
import org.jetbrains.compose.web.css.JustifyContent.Companion.SpaceEvenly
import org.jetbrains.compose.web.css.Position.Companion.Relative
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
import web.compose.material3.checkbox.indeterminate
import web.compose.material3.dialog.Dialog
import web.compose.material3.dialog.onClosed
import web.compose.material3.dialog.onClosing
import web.compose.material3.dialog.open
import web.compose.material3.disabled
import web.compose.material3.divider.Divider
import web.compose.material3.elevation.Elevation
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
import web.compose.material3.navigationdrawer.ModalNavigationDrawer
import web.compose.material3.navigationdrawer.NavigationDrawer
import web.compose.material3.navigationdrawer.opened
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
import web.compose.material3.tabs.*
import web.compose.material3.textfield.*
import web.compose.material3.textfield.TextFieldType.*
import web.compose.material3.themes.defaultColorScheme
import web.compose.material3.themes.defaultDarkColorScheme
import web.compose.material3.themes.defaultFontScheme
import web.compose.material3.theming.MaterialTheme
import web.compose.material3.theming.MdSysColorVariables
import web.compose.material3.theming.MdSysTypeScaleTokens
import web.compose.material3.theming.SysColorScheme
import web.compose.material3.theming.TypeScaleTokens.Companion.applyStyle

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

    MaterialTheme(currentColorScheme, defaultFontScheme) {

        LargeDisplay("Kotlin HTML")
        LargeHeadline("Material Design 3 Web Components Examples")

        LargeBody {
            Text(
                """
                This pages shows examples of the Material Design 3 Components in Kotlin which wrap the web components 
                being developed at 
            """.trimIndent()
            )

            A(href = "https://github.com/material-components/material-web") { Text("https://github.com/material-components/material-web") }

            Div({
                style {
                    display(Flex)
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
                        currentColorScheme =
                            if (currentColorScheme == lightColorScheme)
                                darkColorScheme
                            else
                                lightColorScheme
                    }
                })
            }
        }

        var activeTab by remember { mutableStateOf(0) }
        Tabs({
            variant = Variant.PRIMARY
            selected = activeTab
            onChange { activeTab = it.target.asDynamic().selected }
        }) {
            Tab {
                Icon("check_circle")
                Text("Stable widgets")

            }
            Tab {
                Icon("circle")
                Text("Beta widgets")
            }
            Tab {
                Icon("bolt")
                Text("Alfa widgets")
            }
            Tab {
                Icon("add_circle")
                Text("Extra widgets")
            }
        }

        Div {
            when (activeTab) {
                0 -> WidgetGroup("Stable widgets") {
                    Row {
                        Column {
                            LargeTitle("Divider")

                            LargeBody("Some content divided")
                            Divider()
                            LargeBody("by a divider")
                        }
                        Column {
                            LargeTitle("Elevation")

                            val elevationStyleSheet = object : StyleSheet() {
                                val box by style {
                                    margin(8.px)
                                    backgroundColor(MdSysColorVariables.mdSysColorPrimaryContainer.value())
                                    borderWidth(0.px);
                                    borderRadius(16.px);
                                    color(MdSysColorVariables.mdSysColorOnPrimaryContainer.value())
                                    display(Flex)
                                    justifyContent(JustifyContent.Center)
                                    position(Relative) /* This is needed for Elevation to work correctly */
                                    width(80.px)
                                }
                            }
                            Style(elevationStyleSheet)

                            Div({ classes(elevationStyleSheet.box) }) {
                                LargeBody("Level 0")
                                Elevation(0)
                            }
                            Div({ classes(elevationStyleSheet.box) }) {
                                LargeBody("Level 1")
                                Elevation(1)
                            }
                            Div({ classes(elevationStyleSheet.box) }) {
                                LargeBody("Level 2")
                                Elevation(2)
                            }
                            Div({ classes(elevationStyleSheet.box) }) {
                                LargeBody("Level 3")
                                Elevation(3)
                            }
                            Div({ classes(elevationStyleSheet.box) }) {
                                LargeBody("Level 4")
                                Elevation(4)
                            }
                        }
                    }
                }

                1 -> WidgetGroup("Beta widgets") {
                    Column {
                        Row {
                            Column {
                                LargeTitle("Fields")

                                FilledField({
                                    label = "A label"
                                }) {
                                    LargeBody("Some text")

                                    Icon({slot = "start"}, "search")
                                    Icon({slot = "end"}, "event")
                                    Span({slot = "supporting-text"}) { Text("Supporting text") }
                                    Span({slot = "supporting-text-end"}) { Text("Supporting text end") }
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
                                    Icon({ slot = "icon" }, "edit")
                                }
                                Fab {
                                    Icon({ slot = "icon" }, "delete")
                                }
                                Fab({ size = LARGE }) {
                                    Icon({ slot = "icon" }, "add")
                                }
                                Fab({ label = "FAB" })
                            }

                            Column {
                                LargeTitle("Icon Buttons")
                                var toggleButtonSelected by remember { mutableStateOf(false) }

                                FilledIconButton({
                                    onClick { textFieldValue = "filled icon button clicked" }
                                    style { padding(5.px) }
                                }) { Icon("star") }
                                OutlinedIconButton({
                                    onClick { textFieldValue = "outlined icon button clicked" }
                                    style { padding(5.px) }
                                }) { Icon("login") }
                                TonalIconButton({
                                    onClick { textFieldValue = "tonal icon button clicked" }
                                    style { padding(5.px) }
                                }) { Icon("public") }
                                StandardIconButton({
                                    onClick { toggleButtonSelected = !toggleButtonSelected }
                                    style { padding(5.px) }
                                }) { Icon("menu") }
                                FilledIconButton({
                                    toggle()
                                    selected(toggleButtonSelected)
                                    style { padding(5.px) }
                                }) {
                                    Icon("lock")
                                    Icon({ slot = "selectedIcon" }, "lock_open")
                                }
                                FilledIconButton({
                                    disabled()
                                    style { padding(5.px) }
                                }) {
                                    Icon("star")
                                }
                            }

                            Column {
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
                                    Icon({ slot = "start" }, "edit")
                                    Icon({ slot = "start" }, "delete")
                                    Icon({ slot = "end" }, "close")
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

                                LargeTitle("Checkbox")
                                Label(null, {style { display(Flex); alignItems(AlignItems.Center) }}) {
                                    Checkbox({
                                        checked(checkboxStatus)
                                        onClick {
                                            checkboxStatus = !checkboxStatus
                                        }
                                    })
                                    LargeLabel("Enabled checkbox", true)
                                }
                                Label(null, {style { display(Flex); alignItems(AlignItems.Center) }}) {
                                    Checkbox({
                                        indeterminate()
                                    })
                                    LargeLabel("Indeterminate checkbox", true)
                                }
                                Label(null, {style { display(Flex); alignItems(AlignItems.Center) }}) {
                                    Checkbox({
                                        checked(checkboxStatus)
                                        onClick {
                                            checkboxStatus = !checkboxStatus
                                        }
                                        disabled()
                                    })
                                    LargeLabel("Disabled checkbox", true)
                                }

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
                                Label(null, {style { display(Flex); alignItems(AlignItems.Center) }}) {
                                    Radio({
                                        name = "radio-group"
                                        value = "o1"
                                        checked(radioValue == "o1")
                                        onChange { radioValue = "o1" }
                                    })
                                    LargeLabel("Option 1", inline = true)
                                }
                                Label(null, {style { display(Flex); alignItems(AlignItems.Center) }}) {
                                    Radio({
                                        name = "radio-group"
                                        value = "o2"
                                        checked(radioValue == "o2")
                                        onChange { radioValue = "o2" }
                                    })
                                    LargeLabel("Option 2", inline = true)
                                }
                                Label(null, {style { display(Flex); alignItems(AlignItems.Center) }}) {
                                    Radio({
                                        name = "radio-group"
                                        value = "o3"
                                        checked(radioValue == "o3")
                                        onChange { radioValue = "o3" }
                                    })
                                    LargeLabel("Option 3", inline = true)
                                }
                                Label(null, {style { display(Flex); alignItems(AlignItems.Center) }}) {
                                    Radio({
                                        name = "radio-group"
                                        value = "o4"
                                        disabled()
                                        checked(radioValue == "o4")
                                        onChange { radioValue = "o4" }
                                    })
                                    LargeLabel("Option 4", inline = true)
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
                    }
                }

                2 -> WidgetGroup("Alpha widgets") {
                    Column {
                        LargeTitle("Navigation Drawer")
                        var opened by remember { mutableStateOf(false) }

                        OutlinedButton({
                            onClick { opened = !opened }
                            style { padding(5.px) }
                        }) { Text("${if(opened) "close" else "open"} drawer") }

                        NavigationDrawer({opened(opened)}) {
                            LargeBody("Navigation drawer")
                        }
                    }

                    Column {
                        LargeTitle("Modal Navigation Drawer")

                        var opened by remember { mutableStateOf(false) }

                        OutlinedButton({
                            onClick { opened = !opened }
                            style { padding(5.px) }
                        }) { Text("${if(opened) "close" else "open"} drawer") }

                        ModalNavigationDrawer({opened(opened)}) {
                            LargeBody("Modal navigation drawer")
                        }
                    }

                    Column {
                        LargeTitle("Badges")

                        Row {
                            TonalIconButton({
                                onClick { textFieldValue = "tonal icon button clicked" }
                                style { padding(5.px) }
                            }) {
                                Icon("public")
                                Badge()
                            }

                            TonalIconButton({
                                onClick { textFieldValue = "tonal icon button clicked" }
                                style { padding(5.px) }
                            }) {
                                Icon("public")
                                Badge({ value = "1" })
                            }

                            TonalIconButton({
                                onClick { textFieldValue = "tonal icon button clicked" }
                                style { padding(5.px) }
                            }) {
                                Icon("public")
                                Badge({ value = "999+" })
                            }
                        }
                    }
                }

                3 -> WidgetGroup("Extra widgets") {
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

                    Column {
                        LargeTitle("Text area")

                        FilledField {
                            TextArea(attrs = {
                                defaultValue("Some Default Text")
                                style {
                                    outline("none")
                                    background("transparent")
                                    boxSizing("border-box")
                                    border {style = LineStyle.None}
                                    width(100.percent)
                                    applyStyle(MdSysTypeScaleTokens.bodyLarge)
                                }
                                wrap(TextAreaWrap.Off)
                                rows(5) }
                            )
                            Span({slot = "supporting-text"}) { Text("Some longer supporting text") }
                        }

                        OutlinedField {
                            TextArea(attrs = {
                                defaultValue("Some Default Text")
                                style {
                                    outline("none")
                                    background("transparent")
                                    boxSizing("border-box")
                                    border {style = LineStyle.None}
                                    width(100.percent)
                                    applyStyle(MdSysTypeScaleTokens.bodyLarge)
                                }
                                wrap(TextAreaWrap.Off)
                                rows(5) }
                            )
                            Span({slot = "supporting-text"}) { Text("Some longer supporting text") }
                        }
                    }

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
                                LargeBody("Drag & drop files here!")
                            else
                                FileListInfo(selectedFiles)
                        }
                    }
                }
            }
        }

        ExampleNavigationBar()
    }
}

@Composable
fun FileList(files: List<File>) {
    Column() {
        files.forEach {
            LargeLabel("Filename: ${it.name} [${it.size}, ${it.type}], ${it.lastModified}")
        }
    }
}

@Composable
fun FileListInfo(files: List<File>) {
    val totalFileSize = files.sumOf { it.size.toInt() }
    LargeLabel("Number of files: ${files.size}")
    LargeLabel("Total amount of bytes: ${formatBytes(totalFileSize)}")
}
