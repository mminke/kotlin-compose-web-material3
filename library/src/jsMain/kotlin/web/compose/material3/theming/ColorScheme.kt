package web.compose.material3.theming

import org.jetbrains.compose.web.css.*

//TODO: Palette: https://github.com/material-components/material-web/blob/main/tokens/v0_172/_md-ref-palette.scss

data class ColorScheme(
    val sysColorPrimary: CSSColorValue,
    val sysColorPrimaryContainer: CSSColorValue,
    val sysColorOnPrimary: CSSColorValue,
    val sysColorOnPrimaryContainer: CSSColorValue,
    val sysColorSecondary: CSSColorValue,
    val sysColorSecondaryContainer: CSSColorValue,
    val sysColorOnSecondary: CSSColorValue,
    val sysColorOnSecondaryContainer: CSSColorValue,
    val sysColorTertiary: CSSColorValue,
    val sysColorTertiaryContainer: CSSColorValue,
    val sysColorOnTertiary: CSSColorValue,
    val sysColorOnTertiaryContainer: CSSColorValue,
    val sysColorError: CSSColorValue,
    val sysColorErrorContainer: CSSColorValue,
    val sysColorOnError: CSSColorValue,
    val sysColorOnErrorContainer: CSSColorValue,
    val sysColorOutline: CSSColorValue,
    val sysColorBackground: CSSColorValue,
    val sysColorOnBackground: CSSColorValue,
    val sysColorSurface: CSSColorValue,
    val sysColorOnSurface: CSSColorValue,
    val sysColorSurfaceVariant: CSSColorValue,
    val sysColorOnSurfaceVariant: CSSColorValue,
//sysColorSurfaceDim = Color("#141218"),
//sysColorSurfaceBright = Color("#3B383E"),
    val sysColorSurfaceContainerLowest: CSSColorValue,
//sysColorSurfaceContainerLow = Color("#1D1B20"),
//sysColorSurfaceContainer = Color("#211F26"),
//sysColorSurfaceContainerHigh = Color("#2B2930"),
//sysColorSurfaceContainerHighest = Color("#36343B"),

    val sysColorInverseSurface: CSSColorValue,
    val sysColorInverseOnSurface: CSSColorValue,
    val sysColorInversePrimary: CSSColorValue,
    val sysColorShadow: CSSColorValue,
    val sysColorSurfaceTint: CSSColorValue,
    val sysColorOutlineVariant: CSSColorValue,
    val sysColorScrim: CSSColorValue
) {
    fun asStylesheet(): StyleSheet = StyleSheet().apply {
        root style {
            backgroundColor(MdSysColorVariables.mdSysColorSurfaceContainerLowest.value())
            color(MdSysColorVariables.mdSysColorOnBackground.value())
        }

        universal style {
            MdSysColorVariables.mdSysColorPrimary(sysColorPrimary)
            MdSysColorVariables.mdSysColorPrimaryContainer(sysColorPrimaryContainer)
            MdSysColorVariables.mdSysColorOnPrimary(sysColorOnPrimary)
            MdSysColorVariables.mdSysColorOnPrimaryContainer(sysColorOnPrimaryContainer)
            MdSysColorVariables.mdSysColorSecondary(sysColorSecondary)
            MdSysColorVariables.mdSysColorSecondaryContainer(sysColorSecondaryContainer)
            MdSysColorVariables.mdSysColorOnSecondary(sysColorOnSecondary)
            MdSysColorVariables.mdSysColorOnSecondaryContainer(sysColorOnSecondaryContainer)
            MdSysColorVariables.mdSysColorTertiary(sysColorTertiary)
            MdSysColorVariables.mdSysColorTertiaryContainer(sysColorTertiaryContainer)
            MdSysColorVariables.mdSysColorOnTertiary(sysColorOnTertiary)
            MdSysColorVariables.mdSysColorOnTertiaryContainer(sysColorOnTertiaryContainer)
            MdSysColorVariables.mdSysColorError(sysColorError)
            MdSysColorVariables.mdSysColorErrorContainer(sysColorErrorContainer)
            MdSysColorVariables.mdSysColorOnError(sysColorOnError)
            MdSysColorVariables.mdSysColorOnErrorContainer(sysColorOnErrorContainer)
            MdSysColorVariables.mdSysColorOutline(sysColorOutline)
            MdSysColorVariables.mdSysColorBackground(sysColorBackground)
            MdSysColorVariables.mdSysColorOnBackground(sysColorOnBackground)
            MdSysColorVariables.mdSysColorSurface(sysColorSurface)
            MdSysColorVariables.mdSysColorOnSurface(sysColorOnSurface)
            MdSysColorVariables.mdSysColorSurfaceVariant(sysColorSurfaceVariant)
            MdSysColorVariables.mdSysColorOnSurfaceVariant(sysColorOnSurfaceVariant)
            MdSysColorVariables.mdSysColorSurfaceContainerLowest(sysColorSurfaceContainerLowest)
            MdSysColorVariables.mdSysColorInverseSurface(sysColorInverseSurface)
            MdSysColorVariables.mdSysColorInverseOnSurface(sysColorInverseOnSurface)
            MdSysColorVariables.mdSysColorInversePrimary(sysColorInversePrimary)
            MdSysColorVariables.mdSysColorShadow(sysColorShadow)
            MdSysColorVariables.mdSysColorSurfaceTint(sysColorSurfaceTint)
            MdSysColorVariables.mdSysColorOutlineVariant(sysColorOutlineVariant)
            MdSysColorVariables.mdSysColorScrim(sysColorScrim)
        }
    }
}

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
    val mdSysColorSurfaceContainerLowest = CSSStyleVariable<CSSColorValue>("md-sys-color-surface-container-lowest")
    val mdSysColorInverseSurface = CSSStyleVariable<CSSColorValue>("md-sys-color-inverse-surface")
    val mdSysColorInverseOnSurface = CSSStyleVariable<CSSColorValue>("md-sys-color-inverse-on-surface")
    val mdSysColorInversePrimary = CSSStyleVariable<CSSColorValue>("md-sys-color-inverse-primary")
    val mdSysColorShadow = CSSStyleVariable<CSSColorValue>("md-sys-color-shadow")
    val mdSysColorSurfaceTint = CSSStyleVariable<CSSColorValue>("md-sys-color-surface-tint")
    val mdSysColorOutlineVariant = CSSStyleVariable<CSSColorValue>("md-sys-color-outline-variant")
    val mdSysColorScrim = CSSStyleVariable<CSSColorValue>("md-sys-color-scrim")
}
