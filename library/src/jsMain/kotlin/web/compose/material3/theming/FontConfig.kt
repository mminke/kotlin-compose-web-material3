package web.compose.material3.theming

import org.jetbrains.compose.web.css.CSSColorValue
import org.jetbrains.compose.web.css.CSSNumeric
import org.jetbrains.compose.web.css.CSSSizeValue
import org.jetbrains.compose.web.css.CSSStyleVariable
import org.jetbrains.compose.web.css.CSSUnit
import org.jetbrains.compose.web.css.CSSUnitValueTyped
import org.jetbrains.compose.web.css.StylePropertyString
import org.jetbrains.compose.web.css.StyleScope
import org.jetbrains.compose.web.css.StyleSheet
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.fontFamily
import org.jetbrains.compose.web.css.fontSize
import org.jetbrains.compose.web.css.fontWeight
import org.jetbrains.compose.web.css.letterSpacing
import org.jetbrains.compose.web.css.lineHeight
import org.jetbrains.compose.web.css.number
import org.jetbrains.compose.web.css.unaryMinus
import org.jetbrains.compose.web.css.value

open class TypeScaleTokens(
    val tokenBase: String
) {
    inner open class Role(
        tokenName: String
    ) {
        val font = CSSStyleVariable<StylePropertyString>("$tokenBase-$tokenName-font")
        val size = CSSStyleVariable<CSSNumeric>("$tokenBase-$tokenName-size")
        val lineHeight = CSSStyleVariable<CSSNumeric>("$tokenBase-$tokenName-line-height")
        val tracking = CSSStyleVariable<CSSNumeric>("$tokenBase-$tokenName-tracking")
        val weight = CSSStyleVariable<CSSNumeric>("$tokenBase-$tokenName-weight")
    }

    companion object {
        fun StyleScope.applyStyle(role: Role) {
            fontFamily(role.font.value().toString())
            fontSize(role.size.value())
            lineHeight(role.lineHeight.value())
            letterSpacing(role.tracking.value())
            fontWeight(role.weight.value().toString())
        }
    }
}

object MdRefTypeFaceTokens {
    val mdRefTypeFaceBrand = CSSStyleVariable<CSSColorValue>("md-ref-typeface-brand")
}

object MdSysTypeScaleTokens : TypeScaleTokens("md-sys-typescale") {

    object displayLarge : Role("display-large")
    object displayMedium : Role("display-medium")
    object displaySmall : Role("display-small")
    object headlineLarge : Role("headline-large")
    object headlineMedium : Role("headline-medium")
    object headlineSmall : Role("headline-small")
    object titleLarge : Role("title-large")
    object titleMedium : Role("title-medium")
    object titleSmall : Role("title-small")
    object bodyLarge : Role("body-large")
    object bodyMedium : Role("body-medium")
    object bodySmall : Role("body-small")
    object labelLarge : Role("label-large")
    object labelMedium : Role("label-medium")
    object labelSmall : Role("label-small")

}

data class FontConfig(
    val font: String,
    val size: CSSNumeric,
    val lineHeight: CSSNumeric,
    val tracking: CSSNumeric,
    val weight: CSSNumeric
)

val Number.sp
    get(): CSSSizeValue<CSSUnit.rem> = CSSUnitValueTyped(this.toFloat() * 0.0625f, CSSUnit.rem)


data class SysFontScheme(
    val displayLarge: FontConfig = FontConfig("Roboto", 57.sp, 64.sp, -0.25.cssRem, 400.number),
    val displayMedium: FontConfig = FontConfig("Roboto", 45.sp, 52.sp, 0.cssRem, 400.number),
    val displaySmall: FontConfig = FontConfig("Roboto", 36.sp, 44.sp, 0.cssRem, 400.number),

    val headlineLarge: FontConfig = FontConfig("Roboto", 32.sp, 40.sp, 0.cssRem, 400.number),
    val headlineMedium: FontConfig = FontConfig("Roboto", 28.sp, 36.sp, 0.cssRem, 400.number),
    val headlineSmall: FontConfig = FontConfig("Roboto", 24.sp, 32.sp, 0.cssRem, 400.number),

    val titleLarge: FontConfig = FontConfig("Roboto", 22.sp, 28.sp, 0.cssRem, 400.number),
    val titleMedium: FontConfig = FontConfig("Roboto", 16.sp, 24.sp, 0.15.cssRem, 500.number),
    val titleSmall: FontConfig = FontConfig("Roboto", 14.sp, 20.sp, 0.1.cssRem, 500.number),

    val bodyLarge: FontConfig = FontConfig("Roboto", 16.sp, 24.sp, 0.5.cssRem, 400.number),
    val bodyMedium: FontConfig = FontConfig("Roboto", 14.sp, 20.sp, 0.25.cssRem, 400.number),
    val bodySmall: FontConfig = FontConfig("Roboto", 12.sp, 16.sp, 0.4.cssRem, 400.number),

    val labelLarge: FontConfig = FontConfig("Roboto", 14.sp, 20.sp, 0.1.cssRem, 500.number),
    val labelMedium: FontConfig = FontConfig("Roboto", 12.sp, 16.sp, 0.5.cssRem, 500.number),
    val labelSmall: FontConfig = FontConfig("Roboto", 11.sp, 16.sp, 0.5.cssRem, 500.number),
) {
    fun StyleScope.configureTokenValues(role: TypeScaleTokens.Role, fontConfig: FontConfig) {
        role.font(fontConfig.font)
        role.size(fontConfig.size)
        role.lineHeight(fontConfig.lineHeight)
        role.tracking(fontConfig.tracking)
        role.weight(fontConfig.weight)
    }

    fun asStyleSheet(): StyleSheet = StyleSheet().apply {
        universal style {
            configureTokenValues(MdSysTypeScaleTokens.displayLarge, displayLarge)
            configureTokenValues(MdSysTypeScaleTokens.displayMedium, displayMedium)
            configureTokenValues(MdSysTypeScaleTokens.displaySmall, displaySmall)

            configureTokenValues(MdSysTypeScaleTokens.headlineLarge, headlineLarge)
            configureTokenValues(MdSysTypeScaleTokens.headlineMedium, headlineMedium)
            configureTokenValues(MdSysTypeScaleTokens.headlineSmall, headlineSmall)

            configureTokenValues(MdSysTypeScaleTokens.titleLarge, titleLarge)
            configureTokenValues(MdSysTypeScaleTokens.titleMedium, titleMedium)
            configureTokenValues(MdSysTypeScaleTokens.titleSmall, titleSmall)

            configureTokenValues(MdSysTypeScaleTokens.bodyLarge, bodyLarge)
            configureTokenValues(MdSysTypeScaleTokens.bodyMedium, bodyMedium)
            configureTokenValues(MdSysTypeScaleTokens.bodySmall, bodySmall)

            configureTokenValues(MdSysTypeScaleTokens.labelLarge, labelLarge)
            configureTokenValues(MdSysTypeScaleTokens.labelMedium, labelMedium)
            configureTokenValues(MdSysTypeScaleTokens.labelSmall, labelSmall)

        }
    }
}
