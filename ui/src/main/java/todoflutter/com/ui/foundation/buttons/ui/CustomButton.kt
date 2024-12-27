package todoflutter.com.ui.foundation.buttons.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import todoflutter.com.ui.extensions.UIColors
import todoflutter.com.ui.foundation.buttons.domain.CustomButtonUIModel
import todoflutter.com.ui.foundation.text.model.TextUIModel
import todoflutter.com.ui.foundation.text.ui.CustomText

@Composable
fun CustomButton(modifier: Modifier = Modifier, uiModel: CustomButtonUIModel) {
    var clicked by remember { mutableStateOf(false) }
    val interactionSource = remember { MutableInteractionSource() }
    val coroutineScope = rememberCoroutineScope()

    // Determine the background color based on the clicked state
    var backgroundColor = uiModel.backgroundColor

    // Whether the button is enabled
    val enabled = uiModel.enabled

    // Button Modifier handling click event and size
    val buttonModifier = modifier
        .clickable(
            interactionSource = interactionSource,
            indication = null,
            enabled = enabled
        ) {
            if (!clicked) {
                clicked = true
                // Coroutine to handle the delay effect when the button is clicked
                uiModel.action()
                coroutineScope.launch {
                    delay(uiModel.activeEffectDelay)
                    clicked = false
                }
            }
        }
        .then(
            if (uiModel.height > 0) Modifier.height(uiModel.height.dp) else Modifier
        )
        .then(
            when {
                uiModel.fillMaxWidth -> Modifier.fillMaxWidth()
                uiModel.width > 0 -> Modifier.width(uiModel.width.dp)
                else -> Modifier
            }
        )

    uiModel.takeIf { !it.enabled }?.let {
        backgroundColor = UIColors.grayscale_300
    }

    // Border handling based on state
    val border: BorderStroke? = uiModel.borderStroke?.let {
        if (uiModel.activeBorderStroke != null) {
            if (!clicked) it else uiModel.activeBorderStroke
        } else {
            it
        }
    }

    // Elevation change based on clicked state
    val elevation = if (!clicked) {
        CardDefaults.cardElevation(defaultElevation = uiModel.elevation.dp)
    } else {
        CardDefaults.cardElevation(defaultElevation = 0.dp)
    }

    if (uiModel.isVisible) {
        Card(
            colors = CardDefaults.cardColors(containerColor = backgroundColor),
            shape = RoundedCornerShape(uiModel.roundedCornerShape.dp),
            border = if (uiModel.enabled) border else null,
            elevation = elevation,
            modifier = buttonModifier,
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(horizontal = uiModel.horizontalPadding.dp, vertical = 4.dp),
                contentAlignment = uiModel.alignment
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Box(modifier = Modifier.weight(1.0f, false)) {
                        CustomText(
                            uiModel = uiModel.text,
                            enabled = enabled
                        )
                    }
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewOfCustomButton(){
    Column(modifier = Modifier.padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
        ) {
        CustomButton(
            uiModel =
            CustomButtonUIModel(
                text = TextUIModel(
                    text = "Create Account",
                    textStyle = TextStyle(color = UIColors.white, fontSize = 16.sp, fontWeight = FontWeight.Medium)
                ),
                backgroundColor = UIColors.primaryColor,
                activeBorderStroke = BorderStroke(width = 1.dp, color = UIColors.grayscale_600),
                width = 0,
                height = 60,
                roundedCornerShape = 14,
                enabled = true,
                action = {}
            )
        )
        Spacer(modifier = Modifier.height(10.dp))
        CustomButton(
            uiModel =
            CustomButtonUIModel(
                text = TextUIModel(
                    text = "Create Account",
                    textStyle = TextStyle(color = UIColors.white, fontSize = 16.sp, fontWeight = FontWeight.Medium)
                ),
                backgroundColor = UIColors.primaryColor,
                width = 0,
                height = 60,
                roundedCornerShape = 14,
                enabled = false
            )
        )
    }
}


