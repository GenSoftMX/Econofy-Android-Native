package todoflutter.com.econofy.foundation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import todoflutter.com.econofy.R
import todoflutter.com.ui.extensions.UIColors
import todoflutter.com.ui.foundation.images.domain.FlexibleImageSource
import todoflutter.com.ui.foundation.images.domain.FlexibleImageUIModel
import todoflutter.com.ui.foundation.textfield.CustomTextField
import todoflutter.com.ui.foundation.textfield.domain.CustomTextFieldUIModel


@Composable
fun PasswordTextField() {
    val value = remember { mutableStateOf("") }

    val uiModel = CustomTextFieldUIModel(
        label ="Password",
        labelStyle = TextStyle(color = UIColors.grayscale_600, fontSize = 16.sp),
        height = 60.dp,
        borderRadius = 14.dp,
        focusBorderColor = UIColors.primaryColor,
        obscureText = true,
        suffixIcon = FlexibleImageUIModel(
            imageSource = FlexibleImageSource(
                painter = painterResource(
                    R.drawable.hide
                ),
                contentDescription = "test description",
            ),
            size = 22,
            contentScale = ContentScale.Crop
        )
    )

    CustomTextField(value = value, onTextChanged = { value.value = it }, uiModel = uiModel)
}
