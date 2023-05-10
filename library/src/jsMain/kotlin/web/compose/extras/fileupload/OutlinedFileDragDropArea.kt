package web.compose.extras.fileupload

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Div
import org.w3c.dom.asList
import org.w3c.files.File
import web.compose.material3.MdSysColorVariables

object DragDropAreaStyleSheet : StyleSheet() {
    init {
        className("dragdroparea") style {
            overflow("hidden")
            border {
                style(LineStyle.Solid)
                color(MdSysColorVariables.mdSysColorOutline.value(Color("#79747E")))
                width(1.px)
            }
            borderRadius(CSSStyleVariable<CSSNumeric>("md-outlined-button-container-shape").value(4.px))
        }
        className("dragdroparea") + hover style {
            border {
                style(LineStyle.Dashed)
                color(MdSysColorVariables.mdSysColorOutline.value(Color("#79747E")))
                width(1.px)
            }
            borderRadius(CSSStyleVariable<CSSNumeric>("md-outlined-button-container-shape").value(4.px))
        }
    }
}

@Composable
fun OutlinedFileDragDropArea(
    onDrop: ((List<File>) -> Unit)? = null,
    content: @Composable (() -> Unit)? = null
) {
    Style(DragDropAreaStyleSheet)
    Div({
        classes("dragdroparea")
        style {
            minHeight(100.px)
            maxHeight(100.px)
        }
        onDragEnter { it.stopPropagation(); it.preventDefault() }
        onDragOver { it.stopPropagation(); it.preventDefault() }
        onDrop {
            it.stopPropagation()
            it.preventDefault()

            val selectedFiles = it.dataTransfer?.files?.asList() ?: emptyList()
            onDrop?.invoke(selectedFiles)
        }
    }) {
        content?.invoke()
    }
}
