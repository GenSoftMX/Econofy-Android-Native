package todoflutter.com.ui.foundation.textfield

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import todoflutter.com.ui.extensions.applySize
import todoflutter.com.ui.foundation.images.ui.CustomFlexibleImage
import todoflutter.com.ui.foundation.text.model.TextUIModel
import todoflutter.com.ui.foundation.text.ui.CustomText
import todoflutter.com.ui.foundation.textfield.domain.CustomTextFieldUIModel

@Composable
fun CustomTextField(
    uiModel: CustomTextFieldUIModel,
    onTextChanged: (String) -> Unit = {},
    value: MutableState<String>
) {

    val modifier = uiModel.modifier.applySize(uiModel.width, uiModel.height)

    OutlinedTextField(
        modifier = modifier,
        value = value.value,
        onValueChange = {
            onTextChanged(it)
        },
        enabled = uiModel.enabled,
        readOnly = uiModel.readOnly,
        textStyle = uiModel.textStyle,
        placeholder = uiModel.placeholder?.let {
            {
                CustomText(
                    uiModel = TextUIModel(
                        text = it,
                        textStyle = uiModel.placeholderStyle
                    )
                )
            }
        },
        label = uiModel.label?.let {
            {
                CustomText(
                    uiModel = TextUIModel(
                        text = it,
                        textStyle = uiModel.placeholderStyle
                    )
                )
            }
        },
        visualTransformation = if (uiModel.obscureText) {
            PasswordVisualTransformation(uiModel.obscuringCharacter.first())
        } else {
            VisualTransformation.None
        },
        trailingIcon = uiModel.suffixIcon?.let { uiImageModel ->
            {
                IconButton(
                    onClick = {
                        uiImageModel.onClick.invoke()
                    }
                ) {
                    CustomFlexibleImage(uiModel = uiImageModel)
                }
            }
        },
        leadingIcon = uiModel.leadingIcon?.let { uiImageModel ->
            {
                IconButton(
                    onClick = {
                        uiImageModel.onClick.invoke()
                    }
                ) {
                    CustomFlexibleImage(uiModel = uiImageModel)
                }
            }
        },
        keyboardOptions = KeyboardOptions(keyboardType = uiModel.keyboardType ?: KeyboardType.Text),
        keyboardActions = KeyboardActions(),
        maxLines = uiModel.maxLines,
        shape = RoundedCornerShape(uiModel.borderRadius),
        colors = OutlinedTextFieldDefaults.colors(
            focusedContainerColor = uiModel.backgroundColor,
            unfocusedContainerColor = uiModel.backgroundColor,
            focusedBorderColor = uiModel.focusBorderColor,
            unfocusedBorderColor = uiModel.borderColor
        )
    )
}
