package web.compose.extras

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.Div
import org.w3c.dom.HTMLDivElement

@Composable
fun Column(
    attrs: AttrBuilderContext<HTMLDivElement>? = null,
    content: ContentBuilder<HTMLDivElement>? = null
) {
    Div(
        attrs = {
            if (attrs != null) attrs()
            style {
                display(DisplayStyle.Flex)
                flexDirection(FlexDirection.Column)
                flexGrow(1)
                padding(5.px)
            }
        },
        content = content
    )
}
