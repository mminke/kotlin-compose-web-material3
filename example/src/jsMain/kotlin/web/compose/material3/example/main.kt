package web.compose.material3.example

import androidx.compose.runtime.*
import org.jetbrains.compose.web.attributes.TextAreaWrap
import org.jetbrains.compose.web.attributes.rows
import org.jetbrains.compose.web.attributes.wrap
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.css.DisplayStyle.Companion.Flex
import org.jetbrains.compose.web.css.JustifyContent.Companion.SpaceEvenly
import org.jetbrains.compose.web.dom.*
import org.jetbrains.compose.web.renderComposable
import org.w3c.files.File
import web.compose.extras.Column
import web.compose.extras.Row
import web.compose.extras.fileupload.FilledFileInput
import web.compose.extras.fileupload.OutlinedFileDragDropArea
import web.compose.extras.layout.BorderLayout
import web.compose.extras.panel.CollapsiblePanel
import web.compose.extras.text.*
import web.compose.material3.buttons.OutlinedButton
import web.compose.material3.disabled
import web.compose.material3.example.components.*
import web.compose.material3.fab.Fab
import web.compose.material3.field.FilledField
import web.compose.material3.field.OutlinedField
import web.compose.material3.icon.Icon
import web.compose.material3.navigationbar.NavigationBar
import web.compose.material3.navigationdrawer.ModalNavigationDrawer
import web.compose.material3.navigationdrawer.NavigationDrawer
import web.compose.material3.navigationdrawer.opened
import web.compose.material3.navigationtab.NavigationTab
import web.compose.material3.navigationtab.label
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
import web.compose.material3.theming.MdSysTypeScaleTokens
import web.compose.material3.theming.TypeScaleTokens.Companion.applyStyle

data class ListDataItem(
    val name: String, val organisation: String
)

val listData = listOf(
    ListDataItem("John Doe", "Example.org"),
    ListDataItem("Jane Doe", "Another.example.org")
)

object MainStyleSheet : StyleSheet() {
    init {
        "body" style {
            height(100.vh)
            margin(0.px)
            padding(0.px)
        }

        "#root" style {
            height(100.percent)
            margin(0.px)
            padding(0.px)
        }
    }
}

fun main() {
    renderComposable(rootElementId = "root") {
        Style(MainStyleSheet)

        Material3WidgetShowCase()
    }
}


@Composable
fun Material3WidgetShowCase() {
    val lightColorScheme = defaultColorScheme
    val darkColorScheme = defaultDarkColorScheme
    var currentColorScheme by remember { mutableStateOf(lightColorScheme) }

    MaterialTheme(currentColorScheme, defaultFontScheme) {

        var westOpened by remember { mutableStateOf(true) }
        var eastOpened by remember { mutableStateOf(true) }

        BorderLayout({ style { backgroundColor(currentColorScheme.sysColorSurfaceContainer) } }) {
            North {
                Div({
                    style {
                        display(Flex)
                        alignItems(AlignItems.Center)
                        justifyContent(JustifyContent.Center)
                        gap(10.px)
                        padding(5.px)
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
            West {
                CollapsiblePanel(westOpened) {
                    LargeTitle("Press Home to show/hide")
                    LargeBody(loremIpsum.take(200))
                }
            }
            Center({
                style {
                    backgroundColor(currentColorScheme.sysColorSurface)
                    borderRadius(25.px)
                }
            }) {
                ShowcaseContent()
            }
            East {
                CollapsiblePanel(eastOpened, reverse = true) {
                    LargeTitle("Press Edit to show/hide")
                    LargeBody(loremIpsum.take(200))
                }
            }
            South {
                NavigationBar {
                    NavigationTab({ label = "Home"; onClick { westOpened = !westOpened } }) {
                        Icon({ slot = "activeIcon" }, "home")
                        Icon({ slot = "inactiveIcon" }, "home")
                    }
                    NavigationTab({ label = "Explore" }) {
                        Icon({ slot = "activeIcon" }, "public")
                        Icon({ slot = "inactiveIcon" }, "public")
                    }
                    NavigationTab({ label = "Edit"; onClick { eastOpened = !eastOpened } }) {
                        Icon({ slot = "activeIcon" }, "edit_note")
                        Icon({ slot = "inactiveIcon" }, "edit_note")
                    }
                    Fab { Icon({ slot = "icon" }, "add") }
                }
            }
        }
    }
}

@Composable
fun ShowcaseContent() {

    var activeTab by remember { mutableStateOf(0) }
    Tabs({
        activeTabIndex = activeTab
        onChange {
            console.info(it)
            activeTab = it.target.asDynamic().activeTabIndex
        }
    }) {
        PrimaryTab {
            Icon("check_circle")
            Text("Stable widgets")
        }
        PrimaryTab {
            Icon("circle")
            Text("Beta widgets")
        }
        PrimaryTab {
            Icon("bolt")
            Text("Alfa widgets")
        }
        PrimaryTab {
            Icon("add_circle")
            Text("Extra widgets")
        }
    }

    Div {
        when (activeTab) {
            0 -> WidgetGroup("Stable widgets") {
                Column {
                    LargeHeadline("Material Design 3 Web Components Examples")

                    LargeBody {
                        Text(
                            """
                            This pages shows examples of the Material Design 3 Components in Kotlin which wrap the web components 
                            being developed at 
                        """.trimIndent()
                        )

                        A(href = "https://github.com/material-components/material-web") { Text("https://github.com/material-components/material-web") }
                    }

                    Row {
                        Column({ style { flex(1) } }) {
                            DividerShowcase()
                        }
                        Column({ style { flex(1) } }) {
                            ElevationShowcase()
                        }

                        Column({ style { flex(1) } }) {
                            FocusRingShowcase()
                        }
                        Column({ style { flex(1) } }) {
                            RippleShowcase()
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

const val loremIpsum = """
Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque vel sodales leo. Morbi in ultricies ante, sit amet venenatis elit. Curabitur justo nunc, sagittis quis ullamcorper a, efficitur quis risus. Praesent at tempor libero. Maecenas tincidunt viverra justo, a finibus risus rutrum et. Donec vitae posuere tellus. Sed luctus, nulla sit amet aliquam lacinia, diam felis sagittis enim, nec vestibulum risus ipsum ac augue. Praesent faucibus ac dui in luctus. Nam vitae ex ac dui consequat ultricies ac et risus. Donec fringilla purus eget sem placerat, a faucibus mi lacinia. Sed metus tellus, iaculis ut sem id, pharetra porttitor ipsum. Morbi laoreet pellentesque dolor eu laoreet. Nam semper consectetur metus, non porttitor ex imperdiet sed. Etiam laoreet vitae ligula finibus vulputate. Nam sed sollicitudin enim, eu mollis nunc. Vestibulum facilisis mollis est ornare tincidunt.

Suspendisse potenti. In at eleifend arcu, in aliquam leo. Nunc feugiat diam sed tortor imperdiet dignissim. Praesent rutrum, lacus sed ornare luctus, eros dui placerat felis, ut condimentum ante felis vel nisl. Suspendisse varius mi ac condimentum egestas. Praesent consequat interdum ex, at dapibus dui vestibulum tempus. Phasellus finibus sollicitudin felis, id placerat urna condimentum at.

Vivamus faucibus, est commodo placerat efficitur, dolor nulla accumsan justo, at gravida elit purus non nulla. Fusce maximus imperdiet consequat. Maecenas vehicula, sem non congue cursus, lectus felis dapibus eros, at interdum mi mi sed leo. Cras suscipit efficitur faucibus. Aenean sit amet eros quis quam laoreet consequat tincidunt in ligula. Sed tincidunt libero eget massa suscipit, quis pretium justo sodales. Pellentesque aliquet, massa quis laoreet commodo, nulla justo elementum ante, eget condimentum sapien ligula at arcu. Integer feugiat at enim nec ultrices. Morbi ornare nisi in aliquet congue. Pellentesque placerat nunc vitae aliquet mollis. Vestibulum dapibus nisl vitae nisl faucibus viverra.

Pellentesque porttitor dapibus vehicula. Proin pretium nibh in condimentum condimentum. Pellentesque fringilla metus ac nulla sodales sagittis. Ut molestie nisi erat, imperdiet consectetur risus dapibus quis. Etiam a convallis libero, in tincidunt ligula. Nam volutpat elementum est sed semper. Praesent in pulvinar purus. Vivamus at nisi ac tortor pulvinar commodo et vel neque. Vivamus tempus a nulla eget facilisis. Morbi pretium porttitor mattis. Phasellus eleifend ex odio, eget pharetra diam varius quis. Donec eu nulla viverra turpis sodales sollicitudin eu consectetur dolor. In consequat leo in tincidunt consectetur.

Sed ac orci eget elit fringilla faucibus. Duis in ex sed est ornare condimentum. Vestibulum sit amet lorem ultrices, rhoncus purus ac, consectetur tortor. Suspendisse tempor cursus lacus, nec dapibus libero eleifend eu. Quisque rhoncus mauris sed porta suscipit. Vestibulum blandit dolor vel justo tristique, vitae consectetur massa vestibulum. Sed maximus lectus ex, pellentesque vestibulum quam blandit vulputate. Donec ut vulputate dolor. Vestibulum nec malesuada purus. Aenean justo velit, dictum id dapibus id, viverra in sapien. Praesent dapibus risus consequat orci consectetur ullamcorper. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Phasellus egestas nec orci non placerat. Etiam vitae erat tempor sapien tincidunt tempus vitae efficitur neque.    
"""