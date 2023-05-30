package web.compose.material3.themes

import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.cssRem
import web.compose.material3.theming.FontConfig
import web.compose.material3.theming.SysColorScheme
import web.compose.material3.theming.SysFontScheme
import web.compose.material3.theming.sp

val defaultColorScheme = SysColorScheme(
    sysColorPrimary = Color("#6750A4"),
    sysColorPrimaryContainer = Color("#EADDFF"),
    sysColorOnPrimary = Color("#FFFFFF"),
    sysColorOnPrimaryContainer = Color("#21005E"),
    sysColorInversePrimary = Color("#D0BCFF"),
    sysColorSecondary = Color("#625B71"),
    sysColorSecondaryContainer = Color("#E8DEF8"),
    sysColorOnSecondary = Color("#FFFFFF"),
    sysColorOnSecondaryContainer = Color("#1E192B"),
    sysColorTertiary = Color("#7D5260"),
    sysColorTertiaryContainer = Color("#FFD8E4"),
    sysColorOnTertiary = Color("#FFFFFF"),
    sysColorOnTertiaryContainer = Color("#370B1E"),
    sysColorSurface = Color("#FEF7FF"),
//sysColorSurfaceDim = Color("#DED8E1"),
//sysColorSurfaceBright = Color("#FEF7FF"),
    sysColorSurfaceContainerLowest = Color("#FFFFFF"),
//sysColorSurfaceContainerLow = Color("#F7F2FA"),
//sysColorSurfaceContainer = Color("#F3EDF7"),
//sysColorSurfaceContainerHigh = Color("#ECE6F0"),
//sysColorSurfaceContainerHighest = Color("#E6E0E9"),
    sysColorSurfaceVariant = Color("#E7E0EC"),
    sysColorOnSurface = Color("#1C1B1F"),
    sysColorOnSurfaceVariant = Color("#49454E"),
    sysColorInverseSurface = Color("#313033"),
    sysColorInverseOnSurface = Color("#F4EFF4"),
    sysColorBackground = Color("#FEF7FF"),
    sysColorOnBackground = Color("#1C1B1F"),
    sysColorError = Color("#B3261E"),
    sysColorErrorContainer = Color("#F9DEDC"),
    sysColorOnError = Color("#FFFFFF"),
    sysColorOnErrorContainer = Color("#410E0B"),
    sysColorOutline = Color("#79747E"),
    sysColorOutlineVariant = Color("#C4C7C5"),
    sysColorShadow = Color("#000000"),
    sysColorSurfaceTint = Color("#6750A4"),
    sysColorScrim = Color("#000000"),
)

val defaultDarkColorScheme = SysColorScheme(
    sysColorPrimary = Color("#D0BCFF"),
    sysColorPrimaryContainer = Color("#4F378B"),
    sysColorOnPrimary = Color("#371E73"),
    sysColorOnPrimaryContainer = Color("#EADDFF"),
    sysColorInversePrimary = Color("#6750A4"),
    sysColorSecondary = Color("#CCC2DC"),
    sysColorSecondaryContainer = Color("#4A4458"),
    sysColorOnSecondary = Color("#332D41"),
    sysColorOnSecondaryContainer = Color("#E8DEF8"),
    sysColorTertiary = Color("#EFB8C8"),
    sysColorTertiaryContainer = Color("#633B48"),
    sysColorOnTertiary = Color("#492532"),
    sysColorOnTertiaryContainer = Color("#FFD8E4"),
    sysColorSurface = Color("#141218"),
//sysColorSurfaceDim = Color("#141218"),
//sysColorSurfaceBright = Color("#3B383E"),
    sysColorSurfaceContainerLowest = Color("#0F0D13"),
//sysColorSurfaceContainerLow = Color("#1D1B20"),
//sysColorSurfaceContainer = Color("#211F26"),
//sysColorSurfaceContainerHigh = Color("#2B2930"),
//sysColorSurfaceContainerHighest = Color("#36343B"),
    sysColorSurfaceVariant = Color("#49454F"),
    sysColorOnSurface = Color("#E6E1E5"),
    sysColorOnSurfaceVariant = Color("#CAC4D0"),
    sysColorInverseSurface = Color("#E6E1E5"),
    sysColorInverseOnSurface = Color("#313033"),
    sysColorBackground = Color("#141218"),
    sysColorOnBackground = Color("#E6E1E5"),
    sysColorError = Color("#F2B8B5"),
    sysColorErrorContainer = Color("#8C1D18"),
    sysColorOnError = Color("#601410"),
    sysColorOnErrorContainer = Color("#F9DEDC"),
    sysColorOutline = Color("#938F99"),
    sysColorOutlineVariant = Color("#444746"),
    sysColorShadow = Color("#000000"),
    sysColorSurfaceTint = Color("#D0BCFF"),
    sysColorScrim = Color("#000000"),
)

val defaultFontScheme = SysFontScheme(
    displayLarge = FontConfig("Roboto", 57.sp, 64.sp, (-0.25/57).cssRem, "400"),
    displayMedium = FontConfig("Roboto", 45.sp, 52.sp, 0.cssRem, "400"),
    displaySmall = FontConfig("Roboto", 36.sp, 44.sp, 0.cssRem, "400"),
    headlineLarge = FontConfig("Roboto", 32.sp, 40.sp, 0.cssRem, "400"),
    headlineMedium = FontConfig("Roboto", 28.sp, 36.sp, 0.cssRem, "400"),
    headlineSmall = FontConfig("Roboto", 24.sp, 32.sp, 0.cssRem, "400"),
    titleLarge = FontConfig("Roboto", 22.sp, 28.sp, 0.cssRem, "400"),
    titleMedium = FontConfig("Roboto", 16.sp, 24.sp, (0.15/16).cssRem, "500"),
    titleSmall = FontConfig("Roboto", 14.sp, 20.sp, (0.1/14).cssRem, "500"),
    bodyLarge = FontConfig("Roboto", 16.sp, 24.sp, (0.5/16).cssRem, "400"),
    bodyMedium = FontConfig("Roboto", 14.sp, 20.sp, (0.25/14).cssRem, "400"),
    bodySmall = FontConfig("Roboto", 12.sp, 16.sp, (0.4/12).cssRem, "400"),
    labelLarge = FontConfig("Roboto", 14.sp, 20.sp, (0.1/14).cssRem, "500"),
    labelMedium = FontConfig("Roboto", 12.sp, 16.sp, (0.5/12).cssRem, "500"),
    labelSmall = FontConfig("Roboto", 11.sp, 16.sp, (0.5/11).cssRem, "500"),
)
