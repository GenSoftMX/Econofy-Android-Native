package todoflutter.com.ui.foundation.textfield.domain

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import todoflutter.com.ui.extensions.UIColors
import todoflutter.com.ui.extensions.UIKeys
import todoflutter.com.ui.foundation.images.domain.FlexibleImageUIModel

data class CustomTextFieldUIModel(
    val modifier: Modifier = Modifier,
    val label: String? = null,
    val labelStyle: TextStyle = TextStyle(),
    val placeholder: String? = null,
    val placeholderStyle: TextStyle = TextStyle(),
    val textStyle: TextStyle = TextStyle(),
    val width: Dp = Dp.Unspecified,
    val height: Dp = Dp.Unspecified,
    val readOnly: Boolean = false,
    val maxLines: Int = UIKeys.TEXT_FIELD_DEFAULT_MAX_LINE,
    val minLines: Int = UIKeys.TEXT_FIELD_DEFAULT_MIN_LINE,
    val enabled: Boolean = true,
    val keyboardType: KeyboardType? = KeyboardType.Text,
    val backgroundColor: Color = UIColors.econofyGrayScale_50,
    val obscureText: Boolean = false,
    val obscuringCharacter: String = UIKeys.TEXT_FIELD_DEFAULT_OBSCURING_CHARACTER,
    val borderRadius: Dp = 14.dp,
    val borderColor: Color = UIColors.grayscale_100,
    val focusBorderColor: Color = UIColors.primaryColor,
    val suffixIcon: FlexibleImageUIModel? = null,
    val leadingIcon: FlexibleImageUIModel? = null
) {
    init {
        require(obscuringCharacter.isNotEmpty()) { "Obscuring character cannot be empty" }
    }
}
