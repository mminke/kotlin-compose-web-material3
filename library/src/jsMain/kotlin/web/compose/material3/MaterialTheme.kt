package web.compose.material3

import androidx.compose.runtime.Composable

external fun require(module: String): dynamic

typealias ThemeContent = @Composable MaterialTheme.() -> Unit

class MaterialTheme{
    constructor() {
        require("@material/web/button/filled-button.js")
        require("@material/web/button/outlined-button.js")
        require("@material/web/button/elevated-button.js")
        require("@material/web/button/text-button.js")
        require("@material/web/button/tonal-button.js")
        require("@material/web/navigationbar/navigation-bar.js")
        require("@material/web/textfield/outlined-text-field.js")
        require("@material/web/textfield/filled-text-field.js")
        require("@material/web/list/list.js")
        require("@material/web/list/list-item.js")
        require("@material/web/icon/icon.js")
        require("@material/web/fab/fab.js")
    }
}

@Composable
fun MaterialTheme(themeContent: ThemeContent) {
    val materialTheme = MaterialTheme()
    materialTheme.themeContent()
}