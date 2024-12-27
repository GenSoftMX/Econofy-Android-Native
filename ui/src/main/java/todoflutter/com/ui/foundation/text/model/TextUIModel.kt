package todoflutter.com.ui.foundation.text.model

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration

data class TextUIModel (
    val text: String,
    val textStyle: TextStyle = TextStyle(),
    val visible: Boolean = true,
    val align: TextAlign = TextAlign.Left,
    val textDecoration: TextDecoration? = null
)