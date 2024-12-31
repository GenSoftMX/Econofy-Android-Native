package todoflutter.com.ui.foundation.images.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import todoflutter.com.ui.extensions.UIKeys
import todoflutter.com.ui.extensions.applySize
import todoflutter.com.ui.foundation.images.domain.FlexibleImageUIModel

@Composable
fun CustomFlexibleImage(
    modifier: Modifier = Modifier,
    uiModel: FlexibleImageUIModel
) {
    val finalModifier = modifier.then(
        if (uiModel.size > UIKeys.UNDEFINED_SIZE) {
            Modifier.size(uiModel.size.dp)
        } else {
            Modifier
                .applySize(width = uiModel.width, height = uiModel.height)
                .padding(start = 0.dp, end = 0.dp)
        }
    )

    when {
        uiModel.imageSource.imageVector != null -> {
            Image(
                imageVector = uiModel.imageSource.imageVector,
                contentDescription = uiModel.imageSource.contentDescription,
                modifier = finalModifier,
                contentScale = uiModel.contentScale,
                alpha = uiModel.alpha
            )
        }

        uiModel.imageSource.painter != null -> {
            Image(
                painter = uiModel.imageSource.painter,
                contentDescription = uiModel.imageSource.contentDescription,
                modifier = finalModifier,
                contentScale = uiModel.contentScale,
                alpha = uiModel.alpha
            )
        }

        else -> throw IllegalArgumentException("Either imageVector or painter must be provided")
    }
}
