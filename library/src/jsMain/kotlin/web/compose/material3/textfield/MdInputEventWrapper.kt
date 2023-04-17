package web.compose.material3.textfield

import androidx.compose.web.events.SyntheticEvent
import org.w3c.dom.events.EventTarget

class MdInputEventWrapper internal constructor(private val syntheticEvent: SyntheticEvent<EventTarget>) {
    val data: String?
        get() = syntheticEvent.nativeEvent.target.asDynamic().value?.unsafeCast<String>()
    val value: String?
        get() = syntheticEvent.nativeEvent.target.asDynamic().value?.unsafeCast<String>()
}