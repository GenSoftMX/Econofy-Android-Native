package todoflutter.com.econofy.ui.splash

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import todoflutter.com.econofy.R
import todoflutter.com.ui.extensions.UIColors
import todoflutter.com.ui.foundation.images.domain.CustomLocalImageModel
import todoflutter.com.ui.foundation.images.ui.CustomLocalImage
import todoflutter.com.ui.foundation.text.model.TextUIModel
import todoflutter.com.ui.foundation.text.ui.CustomText

class SplashViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val uiModel = CustomLocalImageModel(
                action = { println("Image clicked!") },
                painter = painterResource(id = R.drawable.econofy),
                contentScale = ContentScale.Crop,
                contentDescription = "Preview Image",
                width = 177,
                height = 177,
                roundedCornerShape = 0,
                isVisible = true
            )

            Column(modifier = Modifier.fillMaxSize(),horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
                CustomLocalImage(uiModel = uiModel)
                Spacer(modifier = Modifier.height(32.dp))
                CustomText(
                    uiModel = TextUIModel(
                        text = stringResource(R.string.app_name),
                        textStyle = TextStyle(color = UIColors.primaryColor,fontSize = 32.sp, fontWeight = FontWeight.SemiBold)
                    )
                )
            }
        }
    }
}