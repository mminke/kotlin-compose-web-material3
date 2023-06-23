package web.compose.material3.example.components

import androidx.compose.runtime.*
import web.compose.extras.text.LargeLabel
import web.compose.extras.text.LargeTitle
import web.compose.material3.example.listData
import web.compose.material3.list.List
import web.compose.material3.list.ListItem
import web.compose.material3.list.headline
import web.compose.material3.list.supportingText

@Composable
fun ListboxShowcase() {
    var selectedListItemValue by remember { mutableStateOf("Initial text field value") }

    LargeTitle("List box")

    LargeLabel("Selected item name: $selectedListItemValue")

    List {
        listData.forEach { listDateItem ->
            ListItem({
                headline = listDateItem.name
                supportingText = listDateItem.organisation
                onClick {
                    selectedListItemValue = listDateItem.name
                }
            })
        }
    }

}
