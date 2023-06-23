package web.compose.material3.example.components

import androidx.compose.runtime.*
import org.jetbrains.compose.web.css.AlignItems
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.alignItems
import org.jetbrains.compose.web.css.display
import org.jetbrains.compose.web.dom.Label
import web.compose.extras.text.LargeLabel
import web.compose.extras.text.LargeTitle
import web.compose.material3.checkbox.Checkbox
import web.compose.material3.checkbox.checked
import web.compose.material3.checkbox.indeterminate
import web.compose.material3.disabled

@Composable
fun CheckboxShowcase() {
    var checkboxStatus by remember { mutableStateOf(false) }

    LargeTitle("Checkbox")
    Label(null, {style { display(DisplayStyle.Flex); alignItems(AlignItems.Center) }}) {
        Checkbox({
            checked(checkboxStatus)
            onClick {
                checkboxStatus = !checkboxStatus
            }
        })
        LargeLabel("Enabled checkbox", true)
    }
    Label(null, {style { display(DisplayStyle.Flex); alignItems(AlignItems.Center) }}) {
        Checkbox({
            indeterminate()
        })
        LargeLabel("Indeterminate checkbox", true)
    }
    Label(null, {style { display(DisplayStyle.Flex); alignItems(AlignItems.Center) }}) {
        Checkbox({
            checked(checkboxStatus)
            onClick {
                checkboxStatus = !checkboxStatus
            }
            disabled()
        })
        LargeLabel("Disabled checkbox", true)
    }
}
