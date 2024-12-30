package todoflutter.com.econofy.foundation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import todoflutter.com.ui.extensions.UIColors
import todoflutter.com.ui.foundation.textfield.CustomTextField
import todoflutter.com.ui.foundation.textfield.domain.CustomTextFieldUIModel

@Preview(showSystemUi = true)
@Composable
fun NameTextField() {
    val value = remember { mutableStateOf("") }

    val uiModel = CustomTextFieldUIModel(
        label = "Name",
        labelStyle = TextStyle(color = UIColors.grayscale_600, fontSize = 16.sp),
        height = 60.dp,
        borderRadius = 14.dp,
        focusBorderColor = UIColors.primaryColor
    )

    CustomTextField(value = value, onTextChanged = { value.value = it }, uiModel = uiModel)
}