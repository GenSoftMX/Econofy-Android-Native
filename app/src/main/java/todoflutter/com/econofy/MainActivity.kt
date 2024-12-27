package todoflutter.com.econofy

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import todoflutter.com.ui.foundation.buttons.domain.CustomButtonUIModel
import todoflutter.com.ui.foundation.buttons.ui.CustomButton
import todoflutter.com.ui.foundation.text.model.TextUIModel
import todoflutter.com.ui.foundation.text.ui.CustomText

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            HelloMessageWithInitialComponents()
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun HelloMessageWithInitialComponents() {
    val text = remember { mutableStateOf("Click to say Hello word") }
    Column(
        modifier = Modifier.fillMaxSize().padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        CustomText(TextUIModel(text = text.value))
        Spacer(modifier = Modifier.height(10.dp))
        CustomButton(
            uiModel = CustomButtonUIModel(
                text = TextUIModel(text = "Say hello"),
                action = {
                    text.value = "hello word from compose using mutable state"
                })
        )
    }
}
