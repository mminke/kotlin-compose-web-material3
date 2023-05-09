import androidx.compose.runtime.*
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.css.Color.lightgray
import org.jetbrains.compose.web.dom.*
import org.jetbrains.compose.web.renderComposable
import org.w3c.files.File
import web.compose.extras.Column
import web.compose.extras.Row
import web.compose.extras.fileupload.FilledFileInput
import web.compose.extras.fileupload.OutlinedFileDragDropArea
import web.compose.material3.*
import web.compose.material3.buttons.*
import web.compose.material3.dialog.Dialog
import web.compose.material3.dialog.onCancel
import web.compose.material3.dialog.onClose
import web.compose.material3.dialog.open
import web.compose.material3.divider.Divider
import web.compose.material3.fab.Fab
import web.compose.material3.fab.FabSize.LARGE
import web.compose.material3.fab.FabSize.SMALL
import web.compose.material3.fab.label
import web.compose.material3.fab.size
import web.compose.material3.icon.DataVariant
import web.compose.material3.icon.Icon
import web.compose.material3.icon.dataVariant
import web.compose.material3.list.List
import web.compose.material3.list.ListItem
import web.compose.material3.list.headline
import web.compose.material3.list.supportingText
import web.compose.material3.navigationbar.NavigationBar
import web.compose.material3.navigationdrawer.NavigationDrawer
import web.compose.material3.navigationtab.NavigationTab
import web.compose.material3.select.*
import web.compose.material3.textfield.*
import web.compose.material3.textfield.TextFieldType.*
import web.compose.material3.themes.defaultColorScheme
import web.compose.material3.themes.defaultDarkColorScheme
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
        var textFieldValue by remember { mutableStateOf("Initial text field value") }
        var checkboxStatus by remember { mutableStateOf(false) }
        val lightColorScheme = defaultColorScheme
        val darkColorScheme = defaultDarkColorScheme
        var currentColorScheme by remember { mutableStateOf<ColorScheme?>(lightColorScheme) }

        MaterialTheme(currentColorScheme) {
            NavigationBar {
                Text("Switch theme")
                Switch({
                    selected(currentColorScheme != lightColorScheme)
                    onClick {
                        if (currentColorScheme == lightColorScheme)
                            currentColorScheme = darkColorScheme
                        else
                            currentColorScheme = lightColorScheme
                    }
                })
            }

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

            Column {
                H2 { Text("(Almost) stable widget") }

                Row({ style { border { style(LineStyle.Dotted); width(2.px); color(lightgray) } } }) {
                    Column {
                        H3 { Text("Divider") }

                        Divider()
                    }
                }
            }

            Column {
                H2 { Text("Beta widgets") }

                Row({ style { border { style(LineStyle.Dotted); width(2.px); color(lightgray) } } }) {
                    Column {
                        H2 { Text("Buttons") }

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

                        H2 { Text("FAB") }
                        Fab({ size = SMALL }) {
                            Icon({ dataVariant = DataVariant.ICON; slot = "icon" }) { Text("edit") }
                        }
                        Fab {
                            Icon({ dataVariant = DataVariant.ICON; slot = "icon" }) { Text("delete") }
                        }
                        Fab({ size = LARGE }) {
                            Icon({ dataVariant = DataVariant.ICON; slot = "icon" }) { Text("add") }
                        }
                        Fab({ label = "FAB" })
                    }

                    Column {
                        H2 { Text("Dialog") }
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
                        H2 { Text("Misc ") }

                        H3 { Text("Icons") }
                        Row {
                            Icon({ dataVariant = DataVariant.ICON; slot = "start" }) { Text("edit") }
                            Icon({ dataVariant = DataVariant.ICON; slot = "start" }) { Text("delete") }
                            Icon({ dataVariant = DataVariant.ICON; slot = "end" }) { Text("close") }
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

            Column {
                H2 { Text("Alpha widgets.") }

                Row({ style { border { style(LineStyle.Dotted); width(2.px); color(lightgray) } } }) {

                    Column {
                        H3 { Text("Navigation Drawer") }

                        NavigationDrawer {
                            Text("Navigation drawer")
                        }
                    }

                    Column {
                        H3 { Text("Navigation Bar") }
                        Row {
                            NavigationBar {
                                Text("Navigation Bar")
                            }
                        }
                    }

                    Column {
                        H3 { Text("Navigation Tab") }
                        Row{
                            NavigationTab {
                                Text("Navigation Tab")
                            }
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
                        FilledFileInput({
                            if (it == null) return@FilledFileInput
                            selectedFiles = it
                        }) { Text("Upload files...") }

                        FileList(selectedFiles)
                    }
                    Column {
                        H2 { Text("File drag/drop area") }

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


val greenishColorScheme = ColorScheme(
    sysColorPrimary = Color("#006A6A"),
    sysColorPrimaryContainer = Color("#6FF7F6"),
    sysColorOnPrimary = Color("#FFFFFF"),
    sysColorOnPrimaryContainer = Color("#002020"),
    sysColorSecondary = Color("#4A6363"),
    sysColorSecondaryContainer = Color("#CCE8E7"),
    sysColorOnSecondary = Color("#FFFFFF"),
    sysColorOnSecondaryContainer = Color("#051F1F"),
    sysColorTertiary = Color("#4B607C"),
    sysColorTertiaryContainer = Color("#D3E4FF"),
    sysColorOnTertiary = Color("#FFFFFF"),
    sysColorOnTertiaryContainer = Color("#041C35"),
    sysColorError = Color("#BA1A1A"),
    sysColorErrorContainer = Color("#FFDAD6"),
    sysColorOnError = Color("#FFFFFF"),
    sysColorOnErrorContainer = Color("#410002"),
    sysColorOutline = Color("#6F7979"),
    sysColorBackground = Color("#FAFDFC"),
    sysColorOnBackground = Color("#191C1C"),
    sysColorSurface = Color("#FAFDFC"),
    sysColorOnSurface = Color("#191C1C"),
    sysColorSurfaceVariant = Color("#DAE5E4"),
    sysColorOnSurfaceVariant = Color("#3F4948"),
    sysColorInverseSurface = Color("#2D3131"),
    sysColorInverseOnSurface = Color("#EFF1F0"),
    sysColorInversePrimary = Color("#4CDADA"),
    sysColorShadow = Color("#000000"),
    sysColorSurfaceTint = Color("#006A6A"),
    sysColorOutlineVariant = Color("#BEC9C8"),
    sysColorScrim = Color("#000000")
)

val alternativeDarkColorScheme = ColorScheme(
    sysColorPrimary = Color("#4CDADA"),
    sysColorPrimaryContainer = Color("#004F4F"),
    sysColorOnPrimary = Color("#003737"),
    sysColorOnPrimaryContainer = Color("#6FF7F6"),
    sysColorSecondary = Color("#B0CCCB"),
    sysColorSecondaryContainer = Color("#324B4B"),
    sysColorOnSecondary = Color("#1B3534"),
    sysColorOnSecondaryContainer = Color("#CCE8E7"),
    sysColorTertiary = Color("#B3C8E8"),
    sysColorTertiaryContainer = Color("#334863"),
    sysColorOnTertiary = Color("#1C314B"),
    sysColorOnTertiaryContainer = Color("#D3E4FF"),
    sysColorError = Color("#FFB4AB"),
    sysColorErrorContainer = Color("#93000A"),
    sysColorOnError = Color("#690005"),
    sysColorOnErrorContainer = Color("#FFDAD6"),
    sysColorOutline = Color("#889392"),
    sysColorBackground = Color("#191C1C"),
    sysColorOnBackground = Color("#E0E3E2"),
    sysColorSurface = Color("#191C1C"),
    sysColorOnSurface = Color("#E0E3E2"),
    sysColorSurfaceVariant = Color("#3F4948"),
    sysColorOnSurfaceVariant = Color("#BEC9C8"),
    sysColorInverseSurface = Color("#E0E3E2"),
    sysColorInverseOnSurface = Color("#191C1C"),
    sysColorInversePrimary = Color("#006A6A"),
    sysColorShadow = Color("#000000"),
    sysColorSurfaceTint = Color("#4CDADA"),
    sysColorOutlineVariant = Color("#3F4948"),
    sysColorScrim = Color("#000000")
)

