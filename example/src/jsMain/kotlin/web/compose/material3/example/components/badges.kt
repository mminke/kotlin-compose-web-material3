package web.compose.material3.example.components

import androidx.compose.runtime.*
import org.jetbrains.compose.web.css.padding
import org.jetbrains.compose.web.css.px
import web.compose.extras.Row
import web.compose.extras.text.LargeTitle
import web.compose.material3.badge.Badge
import web.compose.material3.badge.value
import web.compose.material3.icon.Icon
import web.compose.material3.iconbutton.TonalIconButton

@Composable
fun BadgeShowcase() {
    var badgeValue by remember { mutableStateOf(1) }

    LargeTitle("Badges")

    Row {
        TonalIconButton({
            style { padding(5.px) }
        }) {
            Icon("public")
            Badge()
        }

        TonalIconButton({
            onClick { badgeValue++  }
            style { padding(5.px) }
        }) {
            Icon("public")
            Badge({ value = badgeValue.toString() })
        }

        TonalIconButton({
            style { padding(5.px) }
        }) {
            Icon("public")
            Badge({ value = "999+" })
        }
    }
}
