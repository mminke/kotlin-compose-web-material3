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
import web.compose.material3.MaterialTheme
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
import web.compose.material3.select.FilledSelect
import web.compose.material3.select.OutlinedSelect
import web.compose.material3.select.SelectOption
import web.compose.material3.select.headline
import web.compose.material3.select.label
import web.compose.material3.select.supportingText
import web.compose.material3.select.value
import web.compose.material3.slot
import web.compose.material3.textfield.*
import web.compose.material3.textfield.TextFieldType.*
import kotlin.math.roundToInt

data class ListDataItem(
    val name: String, val organisation: String
)

val listData = listOf(
    ListDataItem("John Doe", "Example.org"),
    ListDataItem("Jane Doe", "Another.example.org")
)


object MdSysColorVariables {
    val mdSysColorPrimary = CSSStyleVariable<CSSColorValue>("md-sys-color-primary")
    val mdSysColorPrimaryContainer = CSSStyleVariable<CSSColorValue>("md-sys-color-primary-container")
    val mdSysColorOnPrimary = CSSStyleVariable<CSSColorValue>("md-sys-color-on-primary")
    val mdSysColorOnPrimaryContainer = CSSStyleVariable<CSSColorValue>("md-sys-color-on-primary-container")
    val mdSysColorSecondary = CSSStyleVariable<CSSColorValue>("md-sys-color-secondary")
    val mdSysColorSecondaryContainer = CSSStyleVariable<CSSColorValue>("md-sys-color-secondary-container")
    val mdSysColorOnSecondary = CSSStyleVariable<CSSColorValue>("md-sys-color-on-secondary")
    val mdSysColorOnSecondaryContainer = CSSStyleVariable<CSSColorValue>("md-sys-color-on-secondary-container")
    val mdSysColorTertiary = CSSStyleVariable<CSSColorValue>("md-sys-color-tertiary")
    val mdSysColorTertiaryContainer = CSSStyleVariable<CSSColorValue>("md-sys-color-tertiary-container")
    val mdSysColorOnTertiary = CSSStyleVariable<CSSColorValue>("md-sys-color-on-tertiary")
    val mdSysColorOnTertiaryContainer = CSSStyleVariable<CSSColorValue>("md-sys-color-on-tertiary-container")
    val mdSysColorError = CSSStyleVariable<CSSColorValue>("md-sys-color-error")
    val mdSysColorErrorContainer = CSSStyleVariable<CSSColorValue>("md-sys-color-error-container")
    val mdSysColorOnError = CSSStyleVariable<CSSColorValue>("md-sys-color-on-error")
    val mdSysColorOnErrorContainer = CSSStyleVariable<CSSColorValue>("md-sys-color-on-error-container")
    val mdSysColorOutline = CSSStyleVariable<CSSColorValue>("md-sys-color-outline")
    val mdSysColorBackground = CSSStyleVariable<CSSColorValue>("md-sys-color-background")
    val mdSysColorOnBackground = CSSStyleVariable<CSSColorValue>("md-sys-color-on-background")
    val mdSysColorSurface = CSSStyleVariable<CSSColorValue>("md-sys-color-surface")
    val mdSysColorOnSurface = CSSStyleVariable<CSSColorValue>("md-sys-color-on-surface")
    val mdSysColorSurfaceVariant = CSSStyleVariable<CSSColorValue>("md-sys-color-surface-variant")
    val mdSysColorOnSurfaceVariant = CSSStyleVariable<CSSColorValue>("md-sys-color-on-surface-variant")
    val mdSysColorInverseSurface = CSSStyleVariable<CSSColorValue>("md-sys-color-inverse-surface")
    val mdSysColorInverseOnSurface = CSSStyleVariable<CSSColorValue>("md-sys-color-inverse-on-surface")
    val mdSysColorInversePrimary = CSSStyleVariable<CSSColorValue>("md-sys-color-inverse-primary")
    val mdSysColorShadow = CSSStyleVariable<CSSColorValue>("md-sys-color-shadow")
    val mdSysColorSurfaceTint = CSSStyleVariable<CSSColorValue>("md-sys-color-surface-tint")
    val mdSysColorOutlineVariant = CSSStyleVariable<CSSColorValue>("md-sys-color-outline-variant")
    val mdSysColorScrim = CSSStyleVariable<CSSColorValue>("md-sys-color-scrim")
}

object GreenishColorScheme : StyleSheet() {
    init {
        universal style {
//            MyVariables.mdSysColorPrimary(Color("#006A6A"))
//            MyVariables.mdSysColorPrimaryContainer(Color("#6FF7F6"))
//            MyVariables.mdSysColorOnPrimary(Color("#FFFFFF"))
//            MyVariables.mdSysColorOnPrimaryContainer(Color("#002020"))
//            MyVariables.mdSysColorSecondary(Color("#4A6363"))
//            MyVariables.mdSysColorSecondaryContainer(Color("#CCE8E7"))
//            MyVariables.mdSysColorOnSecondary(Color("#FFFFFF"))
//            MyVariables.mdSysColorOnSecondaryContainer(Color("#051F1F"))
//            MyVariables.mdSysColorTertiary(Color("#4B607C"))
//            MyVariables.mdSysColorTertiaryContainer(Color("#D3E4FF"))
//            MyVariables.mdSysColorOnTertiary(Color("#FFFFFF"))
//            MyVariables.mdSysColorOnTertiaryContainer(Color("#041C35"))
//            MyVariables.mdSysColorError(Color("#BA1A1A"))
//            MyVariables.mdSysColorErrorContainer(Color("#FFDAD6"))
//            MyVariables.mdSysColorOnError(Color("#FFFFFF"))
//            MyVariables.mdSysColorOnErrorContainer(Color("#410002"))
//            MyVariables.mdSysColorOutline(Color("#6F7979"))
//            MyVariables.mdSysColorBackground(Color("#FAFDFC"))
//            MyVariables.mdSysColorOnBackground(Color("#191C1C"))
//            MyVariables.mdSysColorSurface(Color("#FAFDFC"))
//            MyVariables.mdSysColorOnSurface(Color("#191C1C"))
//            MyVariables.mdSysColorSurfaceVariant(Color("#DAE5E4"))
//            MyVariables.mdSysColorOnSurfaceVariant(Color("#3F4948"))
//            MyVariables.mdSysColorInverseSurface(Color("#2D3131"))
//            MyVariables.mdSysColorInverseOnSurface(Color("#EFF1F0"))
//            MyVariables.mdSysColorInversePrimary(Color("#4CDADA"))
//            MyVariables.mdSysColorShadow(Color("#000000"))
//            MyVariables.mdSysColorSurfaceTint(Color("#006A6A"))
//            MyVariables.mdSysColorOutlineVariant(Color("#BEC9C8"))
//            MyVariables.mdSysColorScrim(Color("#000000"))
        }
    }
}


fun main() {

    renderComposable(rootElementId = "root") {
        Style(GreenishColorScheme)

        var textFieldValue by remember { mutableStateOf("Initial text field value") }
        var checkboxStatus by remember { mutableStateOf(false) }

        MaterialTheme {
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
                        }) { Text("Outlined Button")}
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

                        H3 { Text("Switch") }
                        Switch({
                            selected(checkboxStatus)
                            onClick { checkboxStatus = !checkboxStatus }
                        })

                        H3 { Text("Slider")}
                        Slider({
                            min = 100
                            max = 200
                            step = 2
                            withLabel()
                        }) {  }

                        H3 { Text("Radio")}
                        Row { Radio({ id("r1"); name = "radio1"; value = "o1"}); Label("r1") { Text("Option 1") } }
                        Row { Radio({ id("r2"); name = "radio1"; value = "o2"}); Label("r2") { Text("Option 2") }}
                        Row { Radio({ id("r3"); name = "radio1"; value = "o3"}); Label("r3") { Text("Option 3") }}

                        H3 { Text("Select")}
                        FilledSelect({
                            label = "Select label"
                            supportingText = "Supporting text"
                        }) {
                            SelectOption {  }
                            SelectOption({ value = "MD1"; headline = "Material Design 1" })
                            SelectOption({ value = "MD2"; headline = "Material Design 2" })
                            SelectOption({ value = "MD3"; headline = "Material Design 3" })
                        }

                        OutlinedSelect({
                            label = "Select label"
                            supportingText = "Supporting text"
                        }) {
                            SelectOption {  }
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
                        H2 { Text("Navigation Bar") }
                        Row {
                            NavigationBar {}
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
                        FilledFileInput( {
                            if (it == null) return@FilledFileInput
                            selectedFiles = it
                        }) {Text("Upload files...")}

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
