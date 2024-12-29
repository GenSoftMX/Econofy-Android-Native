package todoflutter.com.econofy.ui.onboarding

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.InlineTextContent
import androidx.compose.foundation.text.appendInlineContent
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.PlaceholderVerticalAlign
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import todoflutter.com.econofy.R
import todoflutter.com.ui.extensions.UIColors
import todoflutter.com.ui.foundation.buttons.domain.CustomButtonUIModel
import todoflutter.com.ui.foundation.buttons.ui.CustomButton
import todoflutter.com.ui.foundation.images.domain.CustomLocalImageModel
import todoflutter.com.ui.foundation.images.ui.CustomLocalImage
import todoflutter.com.ui.foundation.text.model.TextUIModel
import todoflutter.com.ui.foundation.text.ui.CustomText

class OnboardingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OnboardingScreen()
        }
    }
}

@Composable
fun OnboardingScreen() {
    Surface(modifier = Modifier.fillMaxSize(), color = Color(0xFF3B4054)) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(40.dp))
            OnboardingImage()
            Spacer(modifier = Modifier.height(80.dp))
            OnboardingTexts()
            Spacer(modifier = Modifier.height(32.dp))
            OnboardingDescription()
            Spacer(modifier = Modifier.height(100.dp))
            NavigationDotsAndButtons()
        }
    }
}

@Composable
fun OnboardingImage() {
    val imageModel = CustomLocalImageModel(
        action = { println("Image clicked!") },
        painter = painterResource(id = R.drawable.onboarding_1),
        contentScale = ContentScale.Crop,
        contentDescription = "Preview Image",
        width = 177,
        height = 177,
        roundedCornerShape = 0,
        isVisible = true
    )
    CustomLocalImage(uiModel = imageModel)
}

@Composable
fun OnboardingTexts() {
    CustomText(
        uiModel = TextUIModel(
            text = "The Simple Way to",
            textStyle = TextStyle(
                color = UIColors.white,
                fontSize = 24.sp,
                fontWeight = FontWeight.SemiBold
            )
        )
    )
    Spacer(modifier = Modifier.height(8.dp))
    CustomText(
        uiModel = TextUIModel(
            text = "find the best!",
            textStyle = TextStyle(
                color = UIColors.grayscale_300,
                fontSize = 24.sp,
                fontWeight = FontWeight.Medium
            )
        )
    )
}

@Composable
fun OnboardingDescription() {
    CustomText(
        uiModel = TextUIModel(
            text = "Aenean eu lacinia ligula. Quisque eu risus erat. Aenean placerat sollicitudin lectus.",
            textStyle = TextStyle(
                color = UIColors.lightSteelBlue,
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal
            )
        )
    )
}

@Composable
fun NavigationDotsAndButtons() {
    Box(
        modifier = Modifier
            .height(45.dp)
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        DotsRow()
        NavigationButton(
            text = "Next",
            alignment = Alignment.CenterEnd
        )
        NavigationButton(
            text = "Prev",
            alignment = Alignment.CenterStart
        )
    }
}

@Composable
fun DotsRow() {
    Row(
        modifier = Modifier.padding(horizontal = 50.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        repeat(2) { index ->
            Box(
                modifier = Modifier
                    .background(
                        color = if (index == 1) UIColors.primaryBrand100 else UIColors.primaryBrand4,
                        shape = RoundedCornerShape(20)
                    )
                    .height(4.dp)
                    .width(32.dp)
            )
        }
    }
}

@Composable
fun NavigationButton(text: String, alignment: Alignment) {
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = alignment
    ) {
        CustomButton(
            uiModel = CustomButtonUIModel(
                text = TextUIModel(
                    text = text,
                    textStyle = TextStyle(
                        color = UIColors.lightSteelBlue,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal
                    )
                ),
                width = 70,
                height = 24,
                backgroundColor = Color.Transparent,
                elevation = 0
            )
        )
    }
}

@Composable
fun TextWithImage() {
    val inlineImage = InlineTextContent(
        placeholder = Placeholder(
            width = 24.sp,
            height = 24.sp,
            placeholderVerticalAlign = PlaceholderVerticalAlign.TextCenter
        ),
        children = {
            Image(
                painter = painterResource(id = R.drawable.hand_2),
                contentDescription = null,
                modifier = Modifier.fillMaxSize()
            )
        }
    )

    val annotatedText = buildAnnotatedString {
        append("This is a line of text. ")

        // Insert image inline
        appendInlineContent("image", "[Image]")

        append(" This is another line after the image.")
    }

    Text(
        text = annotatedText,
        style = TextStyle(fontSize = 16.sp, color = Color.Black),
        inlineContent = mapOf("image" to inlineImage)
    )
}

@Preview(showSystemUi = true)
@Composable
fun PreviewOnboardingScreen() {
    OnboardingScreen()
}
