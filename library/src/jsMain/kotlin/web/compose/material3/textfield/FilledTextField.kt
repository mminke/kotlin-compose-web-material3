package web.compose.material3.textfield

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.ElementBuilder
import org.jetbrains.compose.web.dom.TagElement
import org.w3c.dom.Element
import web.compose.material3.ElementBuilderImplementation
import web.compose.material3.InvalidCallException

@Composable
fun FilledTextField(
    attrs: AttrBuilderContext<MdFilledTextFieldElement>? = null,
    content: ContentBuilder<MdFilledTextFieldElement>? = null
) = TagElement(
    elementBuilder = FilledTextFieldElementBuilder,
    applyAttrs = attrs,
    content = content
)

private val FilledTextFieldElementBuilder: ElementBuilder<MdFilledTextFieldElement> =
    ElementBuilderImplementation("md-filled-text-field")

abstract external class MdFilledTextFieldElement : Element


var AttrsScope<MdFilledTextFieldElement>.label: String
    get() {
        throw InvalidCallException()
    }
    set(value) {
        this.attr("label", value)
    }

var AttrsScope<MdFilledTextFieldElement>.value: String
    get() {
        throw InvalidCallException()
    }
    set(value) {
        this.attr("value", value)
    }

fun AttrsScope<MdFilledTextFieldElement>.onInput(handler: (MdInputEventWrapper) -> Unit) {
    addEventListener("input") {
        handler(MdInputEventWrapper(it))
    }
}

//Properties coming from textfield/lib/text-field.ts
//disabled = false;
//error = false;
//errorText = '';
//label?: string;
//required = false;
//value = '';
//defaultValue = '';
//prefixText = '';
//suffixText = '';
//hasLeadingIcon = false;
//hasTrailingIcon = false;
//supportingText = '';
//textDirection = '';


//class TextFieldAttrScope(attrsScope: AttrsScope<HTMLElement>) : AttrsScope<HTMLElement> by attrsScope {
//
//    var value : String
//        get() { throw InvalidCallException() }
//        set(value) { this.attr("value", value) }
//
//    fun onInput(
//        listener: (SyntheticInputEvent<String, HTMLElement>) -> Unit
//    ) {
//        registerEventListener(InputEventListener(EventsListenerScope.INPUT, InputType.Text, listener))
//    }
//}
//
//
//internal class InputEventListener<InputValueType, Target: EventTarget>(
//    eventName: String = EventsListenerScope.INPUT,
//    val inputType: InputType<InputValueType>,
//    listener: (SyntheticInputEvent<InputValueType, Target>) -> Unit
//) : SyntheticEventListener<SyntheticInputEvent<InputValueType, Target>>(
//    eventName, listener
//) {
//    override fun handleEvent(event: Event) {
//        val value = inputType.inputValue(event)
//        listener(SyntheticInputEvent(value, event))
//    }
//}