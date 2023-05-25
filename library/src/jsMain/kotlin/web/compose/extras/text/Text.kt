package web.compose.extras.text

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.Div
import org.w3c.dom.HTMLDivElement
import web.compose.material3.theming.MdSysTypeScaleTokens
import web.compose.material3.theming.TypeScaleTokens
import web.compose.material3.theming.TypeScaleTokens.Companion.applyStyle

@Composable
fun Text(
    role: TypeScaleTokens.Role,
    content: ContentBuilder<HTMLDivElement>? = null
) {
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
    value: String
) {
    Text(role) {
        org.jetbrains.compose.web.dom.Text(value)
    }
}

@Composable
fun LargeDisplay(value: String) = Text(MdSysTypeScaleTokens.displayLarge, value)

@Composable
fun MediumDisplay(value: String) = Text(MdSysTypeScaleTokens.displayMedium, value)

@Composable
fun SmallDisplay(value: String) = Text(MdSysTypeScaleTokens.displaySmall, value)

@Composable
fun LargeHeadline(value: String) = Text(MdSysTypeScaleTokens.headlineLarge, value)

@Composable
fun MediumHeadline(value: String) = Text(MdSysTypeScaleTokens.headlineMedium, value)

@Composable
fun SmallHeadline(value: String) = Text(MdSysTypeScaleTokens.headlineSmall, value)

@Composable
fun LargeTitle(value: String) = Text(MdSysTypeScaleTokens.titleLarge, value)

@Composable
fun MediumTitle(value: String) = Text(MdSysTypeScaleTokens.titleMedium, value)

@Composable
fun SmallTitle(value: String) = Text(MdSysTypeScaleTokens.titleSmall, value)

@Composable
fun LargeBody(value: String) = Text(MdSysTypeScaleTokens.bodyLarge, value)
@Composable
fun LargeBody(content: ContentBuilder<HTMLDivElement>) = Text(MdSysTypeScaleTokens.bodyLarge, content)
@Composable
fun MediumBody(value: String) = Text(MdSysTypeScaleTokens.bodyMedium, value)
@Composable
fun MediumBody(content: ContentBuilder<HTMLDivElement>) = Text(MdSysTypeScaleTokens.bodyMedium, content)
@Composable
fun SmallBody(value: String) = Text(MdSysTypeScaleTokens.bodySmall, value)
@Composable
fun SmallBody(content: ContentBuilder<HTMLDivElement>) = Text(MdSysTypeScaleTokens.bodySmall, content)

@Composable
fun LargeLabel(value: String) = Text(MdSysTypeScaleTokens.labelLarge, value)

@Composable
fun MediumLabel(value: String) = Text(MdSysTypeScaleTokens.labelMedium, value)

@Composable
fun SmallLabel(value: String) = Text(MdSysTypeScaleTokens.labelSmall, value)
