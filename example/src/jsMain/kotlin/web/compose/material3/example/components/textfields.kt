package web.compose.material3.example.components

import androidx.compose.runtime.*
import org.jetbrains.compose.web.css.padding
import org.jetbrains.compose.web.css.px
import web.compose.extras.text.LargeTitle
import web.compose.material3.disabled
import web.compose.material3.textfield.*

@Composable
fun TextFieldShowcase() {
    var textFieldValue by remember { mutableStateOf("Initial text field value") }

    LargeTitle("Text Fields")

    FilledTextField({
        label = "Filled Text Field"
        value = textFieldValue
        onInput {
            textFieldValue = it.value ?: ""
        }
        style { padding(5.px) }
    })

    FilledTextField({
        label = "Filled Text Field"
        value = textFieldValue
        disabled()
        style { padding(5.px) }
    })

    FilledTextField({
        label = "Filled Text Field"
        value = "Some input"
        error = true
        errorText = "No valid input"
        style { padding(5.px) }
    })

    OutlinedTextField({
        label = "Outlined Text Field"
        value = textFieldValue
        onInput {
            textFieldValue = it.value ?: ""
        }
        style { padding(5.px) }
    })

    OutlinedTextField({
        label = "Input a number"
        value = "111"
        type = TextFieldType.NUMBER
        required = true
        style { padding(5.px) }
    })

    OutlinedTextField({
        label = "Input a password"
        value = "Welcome"
        type = TextFieldType.PASSWORD
        style { padding(5.px) }
    })

    OutlinedTextField({
        label = "Input an email"
        value = "john.doe@example.com"
        type = TextFieldType.EMAIL
        style { padding(5.px) }
    })

    OutlinedTextField({
        label = "Input an url"
        value = "https://www.example.com"
        type = TextFieldType.URL
        style { padding(5.px) }
    })

    OutlinedTextField({
        label = "Input an search"
        value = "Some search?"
        type = TextFieldType.SEARCH
        style { padding(5.px) }
    })
}
