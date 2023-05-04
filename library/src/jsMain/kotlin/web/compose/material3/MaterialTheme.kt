package web.compose.material3

import androidx.compose.runtime.Composable

@JsName("require")
external fun jsRequire(module: String): dynamic

typealias ThemeContent = @Composable MaterialTheme.() -> Unit

class MaterialTheme

@Composable
fun MaterialTheme(themeContent: ThemeContent) {
    val materialTheme = MaterialTheme()
    materialTheme.themeContent()
}
