package web.compose.material3.theming

import org.jetbrains.compose.web.css.*

open class TypeScaleTokens(
    val tokenBase: String
) {
    inner open class Role(
        tokenName: String
    ) {
        val font = CSSStyleVariable<StylePropertyString>("$tokenBase-$tokenName-font")
        val size = CSSStyleVariable<CSSNumeric>("$tokenBase-$tokenName-size")
        val lineHeight = CSSStyleVariable<CSSNumeric>("$tokenBase-$tokenName-line-height")
        val letterSpacing = CSSStyleVariable<CSSNumeric>("$tokenBase-$tokenName-letter-spacing")
        val weight = CSSStyleVariable<StylePropertyString>("$tokenBase-$tokenName-weight")
    }

    companion object {
        fun StyleScope.applyStyle(role: Role) {
            fontFamily(role.font.value().toString())
            fontSize(role.size.value())
            lineHeight(role.lineHeight.value())
            letterSpacing(role.letterSpacing.value())
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
    val letterSpacing: CSSNumeric,
    val weight: String
)

val Number.sp
    get(): CSSSizeValue<CSSUnit.rem> = CSSUnitValueTyped(this.toFloat() * 0.0625f, CSSUnit.rem)


data class SysFontScheme(
    val displayLarge: FontConfig,
    val displayMedium: FontConfig,
    val displaySmall: FontConfig,
    val headlineLarge: FontConfig,
    val headlineMedium: FontConfig,
    val headlineSmall: FontConfig,
    val titleLarge: FontConfig,
    val titleMedium: FontConfig,
    val titleSmall: FontConfig,
    val bodyLarge: FontConfig,
    val bodyMedium: FontConfig,
    val bodySmall: FontConfig,
    val labelLarge: FontConfig,
    val labelMedium: FontConfig,
    val labelSmall: FontConfig,
) {
    fun StyleScope.configureTokenValues(role: TypeScaleTokens.Role, fontConfig: FontConfig) {
        role.font(fontConfig.font)
        role.size(fontConfig.size)
        role.lineHeight(fontConfig.lineHeight)
        role.letterSpacing(fontConfig.letterSpacing)
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
