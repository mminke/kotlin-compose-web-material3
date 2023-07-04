package web.compose.material3.example

import androidx.compose.runtime.*
import org.jetbrains.compose.web.attributes.TextAreaWrap
import org.jetbrains.compose.web.attributes.rows
import org.jetbrains.compose.web.attributes.wrap
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.css.DisplayStyle.Companion.Flex
import org.jetbrains.compose.web.css.JustifyContent.Companion.SpaceEvenly
import org.jetbrains.compose.web.css.LineStyle.Companion.Solid
import org.jetbrains.compose.web.css.Position.Companion.Relative
import org.jetbrains.compose.web.dom.*
import org.jetbrains.compose.web.renderComposable
import org.w3c.files.File
import web.compose.extras.Column
import web.compose.extras.Row
import web.compose.extras.fileupload.FilledFileInput
import web.compose.extras.fileupload.OutlinedFileDragDropArea
import web.compose.extras.text.*
import web.compose.material3.buttons.OutlinedButton
import web.compose.material3.disabled
import web.compose.material3.divider.Divider
import web.compose.material3.elevation.Elevation
import web.compose.material3.example.components.*
import web.compose.material3.field.FilledField
import web.compose.material3.field.OutlinedField
import web.compose.material3.icon.Icon
import web.compose.material3.navigationdrawer.ModalNavigationDrawer
import web.compose.material3.navigationdrawer.NavigationDrawer
import web.compose.material3.navigationdrawer.opened
import web.compose.material3.onChange
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

                            val dividerStyleSheet = object : StyleSheet() {
                                val list by style {
                                    border(1.px, Solid, MdSysColorVariables.mdSysColorOutline.value())
                                    margin(0.px)
                                    padding(0.px)
                                    width(200.px)
                                }
                                val listItem by style {
                                    color(MdSysColorVariables.mdSysColorOnBackground.value())
                                    fontFamily("system-ui")
                                    listStyle("none")
                                    margin(16.px)
                                }
                            }
                            Style(dividerStyleSheet)

                            Ul({ classes(dividerStyleSheet.list) }) {
                                Li({ classes(dividerStyleSheet.listItem) }) { LargeLabel("Default divider") }
                                Divider()
                                Li({ classes(dividerStyleSheet.listItem) }) { LargeLabel("Divider (inset = true)") }
                                Divider(inset = true)
                                Li({ classes(dividerStyleSheet.listItem) }) { LargeLabel("Divider (insetStart = true)") }
                                Divider(insetStart = true)
                                Li({ classes(dividerStyleSheet.listItem) }) { LargeLabel("Divider (insetEnd = true)") }
                                Divider(insetEnd = true)
                                Li({ classes(dividerStyleSheet.listItem) }) { LargeLabel("Final item") }
                            }
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
                                FieldsShowcase()
                            }

                            Column {
                                ButtonShowcase()
                            }

                            Column {
                                IconButtonsShowcase()
                            }

                            Column {
                                DialogShowcase()
                            }

                            Column {
                                TextFieldShowcase()
                            }

                            Column {
                                LargeTitle("Misc ")

                                LargeTitle("Icons")
                                Row {
                                    Icon({ slot = "start" }, "edit")
                                    Icon({ slot = "start" }, "delete")
                                    Icon({ slot = "end" }, "close")
                                }

                                ProgressIndicatorShowcase()

                                CheckboxShowcase()

                                SwitchShowcase()

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
                                val radioGroupName = "radio-group"
                                Label(null, { style { display(Flex); alignItems(AlignItems.Center) } }) {
                                    Radio({
                                        name = radioGroupName
                                        value = "o1"
                                        checked(radioValue == "o1")
                                        onChange { radioValue = "o1" }
                                    })
                                    LargeLabel("Option 1", inline = true)
                                }
                                Label(null, { style { display(Flex); alignItems(AlignItems.Center) } }) {
                                    Radio({
                                        name = radioGroupName
                                        value = "o2"
                                        checked(radioValue == "o2")
                                        onChange { radioValue = "o2" }
                                    })
                                    LargeLabel("Option 2", inline = true)
                                }
                                Label(null, { style { display(Flex); alignItems(AlignItems.Center) } }) {
                                    Radio({
                                        name = radioGroupName
                                        value = "o3"
                                        checked(radioValue == "o3")
                                        onChange { radioValue = "o3" }
                                    })
                                    LargeLabel("Option 3", inline = true)
                                }
                                Label(null, { style { display(Flex); alignItems(AlignItems.Center) } }) {
                                    Radio({
                                        name = radioGroupName
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
                                ListboxShowcase()
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
                        }) { Text("${if (opened) "close" else "open"} drawer") }

                        NavigationDrawer({ opened(opened) }) {
                            LargeBody("Navigation drawer")
                        }
                    }

                    Column {
                        LargeTitle("Modal Navigation Drawer")

                        var opened by remember { mutableStateOf(false) }

                        OutlinedButton({
                            onClick { opened = !opened }
                            style { padding(5.px) }
                        }) { Text("${if (opened) "close" else "open"} drawer") }

                        ModalNavigationDrawer({ opened(opened) }) {
                            LargeBody("Modal navigation drawer")
                        }
                    }

                    Column {
                        BadgeShowcase()
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
                                    border { style = LineStyle.None }
                                    width(100.percent)
                                    applyStyle(MdSysTypeScaleTokens.bodyLarge)
                                }
                                wrap(TextAreaWrap.Off)
                                rows(5)
                            }
                            )
                            Span({ slot = "supporting-text" }) { Text("Some longer supporting text") }
                        }

                        OutlinedField {
                            TextArea(attrs = {
                                defaultValue("Some Default Text")
                                style {
                                    outline("none")
                                    background("transparent")
                                    boxSizing("border-box")
                                    border { style = LineStyle.None }
                                    width(100.percent)
                                    applyStyle(MdSysTypeScaleTokens.bodyLarge)
                                }
                                wrap(TextAreaWrap.Off)
                                rows(5)
                            }
                            )
                            Span({ slot = "supporting-text" }) { Text("Some longer supporting text") }
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
