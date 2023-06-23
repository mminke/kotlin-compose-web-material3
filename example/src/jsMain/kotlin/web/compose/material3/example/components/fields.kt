package web.compose.material3.example.components

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text
import web.compose.extras.text.LargeBody
import web.compose.extras.text.LargeTitle
import web.compose.material3.field.*
import web.compose.material3.icon.Icon
import web.compose.material3.slot

@Composable
fun FieldsShowcase() {
    LargeTitle("Fields")

    FilledField({
        label = "A label"
    }) {
        LargeBody("Some text")

        Icon({slot = "start"}, "search")
        Icon({slot = "end"}, "event")
        Span({slot = "supporting-text"}) { Text("Supporting text") }
        Span({slot = "supporting-text-end"}) { Text("Supporting text end") }
    }

    OutlinedField({
        label = "An outlined field label"
        value = "Field value"
    }) {
        LargeBody("Some text")
    }
    OutlinedField({
        error()
        errorText = "An error occured"
        label = "An outlined field label"
        value = "Field value"
    }) {
        LargeBody("Some text")
    }
}
