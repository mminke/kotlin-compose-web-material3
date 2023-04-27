package web.compose.extras.fileupload

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.Style
import org.jetbrains.compose.web.css.StyleSheet
import org.jetbrains.compose.web.css.border
import org.jetbrains.compose.web.css.color
import org.jetbrains.compose.web.css.maxHeight
import org.jetbrains.compose.web.css.minHeight
import org.jetbrains.compose.web.css.overflow
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.style
import org.jetbrains.compose.web.dom.Div
import org.w3c.dom.asList
import org.w3c.files.File

object DragDropAreaStyleSheet : StyleSheet() {
    init {
        className("dragdroparea") style {
            overflow("hidden")
            border {
                style(LineStyle.Solid)
                color(Color.lightgray)
            }
        }
        className("dragdroparea") + hover style {
            border {
                style(LineStyle.Dashed)
                color(Color.darkgray)
            }
        }
    }
}

@Composable
fun FileDragDropArea(
    onDrop: ((List<File>) -> Unit)? = null,
    content: @Composable() (() -> Unit)? = null
) {
    Style(DragDropAreaStyleSheet)
    Div({
        classes("dragdroparea")
        style {
            minHeight(100.px)
            maxHeight(100.px)
        }
        //TODO: Change style when draging over the box
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