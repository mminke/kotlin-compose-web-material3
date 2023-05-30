package web.compose.extras.text

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Span
import org.w3c.dom.HTMLElement
import web.compose.material3.theming.MdSysTypeScaleTokens
import web.compose.material3.theming.TypeScaleTokens
import web.compose.material3.theming.TypeScaleTokens.Companion.applyStyle

@Composable
fun Text(
    role: TypeScaleTokens.Role,
    inline: Boolean = false,
    content: ContentBuilder<HTMLElement>? = null
) {
    if (inline)
        Span(
            {
                style {
                    applyStyle(role)
                }
            },
            content = content
        )
    else
        Div(
            {
                style {
                    applyStyle(role)
                }
            },
            content = content
        )
}

@Composable
fun Text(
    role: TypeScaleTokens.Role,
    inline: Boolean = false,
    value: String
) {
    Text(role, inline) {
        org.jetbrains.compose.web.dom.Text(value)
    }
}

@Composable
fun LargeDisplay(value: String, inline: Boolean = false) = Text(MdSysTypeScaleTokens.displayLarge, inline, value)

@Composable
fun MediumDisplay(value: String, inline: Boolean = false) = Text(MdSysTypeScaleTokens.displayMedium, inline, value)

@Composable
fun SmallDisplay(value: String, inline: Boolean = false) = Text(MdSysTypeScaleTokens.displaySmall, inline, value)

@Composable
fun LargeHeadline(value: String, inline: Boolean = false) = Text(MdSysTypeScaleTokens.headlineLarge, inline, value)

@Composable
fun MediumHeadline(value: String, inline: Boolean = false) = Text(MdSysTypeScaleTokens.headlineMedium, inline, value)

@Composable
fun SmallHeadline(value: String, inline: Boolean = false) = Text(MdSysTypeScaleTokens.headlineSmall, inline, value)

@Composable
fun LargeTitle(value: String, inline: Boolean = false) = Text(MdSysTypeScaleTokens.titleLarge, inline, value)

@Composable
fun MediumTitle(value: String, inline: Boolean = false) = Text(MdSysTypeScaleTokens.titleMedium, inline, value)

@Composable
fun SmallTitle(value: String, inline: Boolean = false) = Text(MdSysTypeScaleTokens.titleSmall, inline, value)

@Composable
fun LargeBody(value: String, inline: Boolean = false) = Text(MdSysTypeScaleTokens.bodyLarge, inline, value)

@Composable
fun LargeBody(inline: Boolean = false, content: ContentBuilder<HTMLElement>) =
    Text(MdSysTypeScaleTokens.bodyLarge, inline, content)

@Composable
fun MediumBody(value: String, inline: Boolean = false) = Text(MdSysTypeScaleTokens.bodyMedium, inline, value)

@Composable
fun MediumBody(inline: Boolean = false, content: ContentBuilder<HTMLElement>) =
    Text(MdSysTypeScaleTokens.bodyMedium, inline, content)

@Composable
fun SmallBody(value: String, inline: Boolean = false) = Text(MdSysTypeScaleTokens.bodySmall, inline, value)

@Composable
fun SmallBody(inline: Boolean = false, content: ContentBuilder<HTMLElement>) =
    Text(MdSysTypeScaleTokens.bodySmall, inline, content)

@Composable
fun LargeLabel(value: String, inline: Boolean = false) = Text(MdSysTypeScaleTokens.labelLarge, inline, value)

@Composable
fun MediumLabel(value: String, inline: Boolean = false) = Text(MdSysTypeScaleTokens.labelMedium, inline, value)

@Composable
fun SmallLabel(value: String, inline: Boolean = false) = Text(MdSysTypeScaleTokens.labelSmall, inline, value)
