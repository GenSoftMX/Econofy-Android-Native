package todoflutter.com.ui.foundation.images.domain

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import kotlin.time.Duration
import kotlin.time.Duration.Companion.milliseconds

data class CustomLocalImageModel(
    val action: () -> Unit = {},
    val painter: Painter,
    val contentScale: ContentScale = ContentScale.Fit,
    val contentDescription: String? = null,
    val width: Int = 0,
    val height: Int = 45,
    val roundedCornerShape: Int = 0,
    val isVisible: Boolean = true,
    val enabled: Boolean = true,
    val activeEffectDelay: Duration = 100.milliseconds
    )
