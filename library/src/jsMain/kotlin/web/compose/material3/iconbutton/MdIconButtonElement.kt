package web.compose.material3.iconbutton

import org.jetbrains.compose.web.attributes.AttrsScope
import web.compose.material3.MdElement

abstract class MdIconButtonElement : MdElement()

fun AttrsScope<MdIconButtonElement>.toggle(value: Boolean = true) {
    if (value) attr("toggle", "")
}
