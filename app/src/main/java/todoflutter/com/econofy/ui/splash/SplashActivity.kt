package todoflutter.com.econofy.ui.splash

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import todoflutter.com.econofy.R
import todoflutter.com.ui.extensions.UIColors
import todoflutter.com.ui.foundation.images.domain.FlexibleImageSource
import todoflutter.com.ui.foundation.images.domain.FlexibleImageUIModel
import todoflutter.com.ui.foundation.images.ui.CustomFlexibleImage
import todoflutter.com.ui.foundation.text.model.TextUIModel
import todoflutter.com.ui.foundation.text.ui.CustomText

class SplashViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            SplashView()
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun SplashView() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        CustomFlexibleImage(
            uiModel = FlexibleImageUIModel(
                FlexibleImageSource(
                    painter = painterResource(
                        id = R.drawable.econofy
                    )
                )
            )
        )
        Spacer(modifier = Modifier.height(32.dp))
        CustomText(
            uiModel = TextUIModel(
                text = stringResource(R.string.app_name),
                textStyle = TextStyle(
                    color = UIColors.primaryColor,
                    fontSize = 32.sp,
                    fontWeight = FontWeight.SemiBold
                )
            )
        )
    }
}