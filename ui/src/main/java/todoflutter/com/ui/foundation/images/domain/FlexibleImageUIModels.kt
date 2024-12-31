package todoflutter.com.ui.foundation.images.domain

import androidx.compose.ui.graphics.DefaultAlpha
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import todoflutter.com.ui.extensions.UIKeys

data class FlexibleImageUIModel(
    val imageSource: FlexibleImageSource,
    val width: Dp = Dp.Unspecified,
    val height: Dp = Dp.Unspecified,
    val size: Int = UIKeys.UNDEFINED_SIZE,
    val contentScale: ContentScale = ContentScale.Fit,
    val alpha: Float = DefaultAlpha,
    val onClick: () -> Unit = { }
)

data class FlexibleImageSource(
    val painter: Painter? = null,
    val imageVector: ImageVector? = null,
    val contentDescription: String? = null
) {
    init {
        require(painter != null || imageVector != null) {
            "Either imageVector or painter must be provided"
        }
    }
}
