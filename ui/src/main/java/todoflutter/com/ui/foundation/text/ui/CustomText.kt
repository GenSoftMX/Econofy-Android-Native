package todoflutter.com.ui.foundation.text.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import todoflutter.com.ui.extensions.UIColors
import todoflutter.com.ui.foundation.text.model.TextUIModel

@Composable
fun CustomText(
    uiModel: TextUIModel,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    maxLines: Int? = null,
    textOverflow: TextOverflow = TextOverflow.Ellipsis
) {

    var textStyle = uiModel.textStyle
    if (!enabled) {
        textStyle = textStyle.copy(color = UIColors.grayscale_600)
    }

    Text(
        modifier = modifier,
        text = uiModel.text,
        overflow = textOverflow,
        style = textStyle,
        maxLines = maxLines ?: Int.MAX_VALUE,
        textAlign = uiModel.align,
        textDecoration = uiModel.textDecoration
    )
}

@Preview(showSystemUi = true)
@Composable
fun PreviewOfCustomText() {
    Column {
        CustomText(
            uiModel = TextUIModel(
                text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. ",
                TextStyle(color = UIColors.black)
            )
        )
        Spacer(modifier = Modifier.height(10.dp))
        CustomText(
            uiModel = TextUIModel(
                text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. ",
                TextStyle(color = UIColors.grayscale_300)
            )
        )
        Spacer(modifier = Modifier.height(10.dp))
        CustomText(
            uiModel = TextUIModel(
                text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. ",
                TextStyle(color = UIColors.grayscale_500)
            )
        )
        Spacer(modifier = Modifier.height(10.dp))
        CustomText(
            uiModel = TextUIModel(
                text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. ",
                TextStyle(color = UIColors.grayscale_600)
            )
        )
    }
}