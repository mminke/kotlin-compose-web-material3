package web.compose.material3.example.components

import androidx.compose.runtime.*
import web.compose.extras.text.LargeTitle
import web.compose.material3.disabled
import web.compose.material3.switch.Switch
import web.compose.material3.switch.selected

@Composable
fun SwitchShowcase() {
    var switchStatus by remember { mutableStateOf(false) }

    LargeTitle("Switch")
    Switch({
        selected(switchStatus)
        onClick { switchStatus = !switchStatus }
    })
    Switch({
        selected(switchStatus)
        onClick { switchStatus = !switchStatus }
        disabled()
    })
}
