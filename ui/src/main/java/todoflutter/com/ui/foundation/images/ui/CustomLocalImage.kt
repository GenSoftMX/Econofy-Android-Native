package todoflutter.com.ui.foundation.images.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import todoflutter.com.ui.foundation.images.domain.CustomLocalImageModel

@Composable
fun CustomLocalImage(modifier: Modifier = Modifier, uiModel: CustomLocalImageModel) {
    var clicked by remember { mutableStateOf(false) }
    val coroutineScope = rememberCoroutineScope()

    if (uiModel.isVisible) {
        val finalModifier = modifier
            .then(
                if (uiModel.height > 0) Modifier.height(uiModel.height.dp) else Modifier
            )
            .then(
                if (uiModel.width > 0) Modifier.width(uiModel.width.dp) else Modifier
            ).then(
                if (!uiModel.enabled) Modifier.alpha(0.5f) else Modifier
            )
            .clip(RoundedCornerShape(uiModel.roundedCornerShape.dp))
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
                enabled = uiModel.enabled
            ) {
                if (!clicked) {
                    clicked = true
                    uiModel.action()
                    coroutineScope.launch {
                        delay(uiModel.activeEffectDelay)
                        clicked = false
                    }
                }
            }

        Image(
            painter = uiModel.painter,
            contentDescription = uiModel.contentDescription,
            contentScale = uiModel.contentScale,
            modifier = finalModifier
        )
    }
}
