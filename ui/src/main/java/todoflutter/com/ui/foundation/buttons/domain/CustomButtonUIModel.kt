package todoflutter.com.ui.foundation.buttons.domain

import androidx.compose.foundation.BorderStroke
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import todoflutter.com.ui.foundation.text.model.TextUIModel
import kotlin.time.Duration
import kotlin.time.Duration.Companion.milliseconds

data class CustomButtonUIModel(
        val text: TextUIModel,
        val action: () -> Unit = {},
        val elevation: Int = 5,
        val fillMaxWidth: Boolean = false,
        val width: Int = 0,
        val height: Int = 45,
        val borderStroke: BorderStroke? = null,
        val activeBorderStroke: BorderStroke? = null,
        val roundedCornerShape: Int = 8,
        val isVisible: Boolean = true,
        val enabled: Boolean = true,
        val backgroundColor: Color = Color.White,
        val horizontalPadding: Int = 10,
        val alignment: Alignment = Alignment.Center,
        val activeEffectDelay: Duration = 100.milliseconds,
    )