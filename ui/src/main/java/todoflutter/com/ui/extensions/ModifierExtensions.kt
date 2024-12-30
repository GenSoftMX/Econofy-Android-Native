package todoflutter.com.ui.extensions

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp

fun Modifier.applySize(width: Dp = Dp.Unspecified, height: Dp = Dp.Unspecified): Modifier = this
    .then(
        if (width != Dp.Unspecified) Modifier.width(width) else Modifier.fillMaxWidth()
    )
    .then(
        if (height != Dp.Unspecified) Modifier.height(height) else Modifier
    )
