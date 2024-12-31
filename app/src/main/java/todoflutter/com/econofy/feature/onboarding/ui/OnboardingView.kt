package todoflutter.com.econofy.feature.onboarding.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.InlineTextContent
import androidx.compose.foundation.text.appendInlineContent
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.PlaceholderVerticalAlign
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import todoflutter.com.econofy.feature.onboarding.viewModel.OnboardingViewModel
import todoflutter.com.econofy.ui.extensions.isNotZero
import todoflutter.com.ui.extensions.UIColors
import todoflutter.com.ui.foundation.buttons.domain.CustomButtonUIModel
import todoflutter.com.ui.foundation.buttons.ui.CustomButton
import todoflutter.com.ui.foundation.images.domain.FlexibleImageSource
import todoflutter.com.ui.foundation.images.domain.FlexibleImageUIModel
import todoflutter.com.ui.foundation.images.ui.CustomFlexibleImage
import todoflutter.com.ui.foundation.text.model.TextUIModel
import todoflutter.com.ui.foundation.text.ui.CustomText

@Preview(showSystemUi = true)
@Composable
fun OnboardingView(viewModel: OnboardingViewModel = OnboardingViewModel()) {
    val state by viewModel.state.collectAsState()

    Surface(modifier = Modifier.fillMaxSize(), color = Color(0xFF3B4054)) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(40.dp))

            CustomFlexibleImage(
                uiModel = FlexibleImageUIModel(
                    imageSource = FlexibleImageSource(
                        painter = painterResource(
                            id = state.steps[state.currentIndex].asset
                        )
                    ), height = 302.dp, width = 302.dp
                )
            )

            Spacer(modifier = Modifier.height(80.dp))

            OnboardingTitle(
                state.steps[state.currentIndex].title,
                state.steps[state.currentIndex].sub,
                state.steps[state.currentIndex].icon
            )

            Spacer(modifier = Modifier.height(44.dp))

            CustomText(
                uiModel = TextUIModel(
                    text = state.steps[state.currentIndex].body,
                    textStyle = TextStyle(
                        color = UIColors.lightSteelBlue,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal
                    )
                )
            )

            Spacer(modifier = Modifier.height(100.dp))

            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.Center
            ) {
                NavigationDotsAndButtons(viewModel)
            }
        }
    }
}


@Composable
fun NavigationDotsAndButtons(viewModel: OnboardingViewModel) {
    val state by viewModel.state.collectAsState()

    Box(
        modifier = Modifier
            .height(45.dp)
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        DotsRow(state.steps.size, state.currentIndex)
        NavigationButton(
            text = "Next",
            alignment = Alignment.CenterEnd,
            action = { viewModel.next() }

        )
        if (state.currentIndex.isNotZero()) {
            NavigationButton(
                text = "Prev",
                alignment = Alignment.CenterStart,
                action = { viewModel.pev() }
            )
        }
    }
}

@Composable
fun DotsRow(steps: Int, currentStep: Int) {
    Row(
        modifier = Modifier.padding(horizontal = 50.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        repeat(steps) { index ->
            val isCurrentIndex = currentStep == index

            Box(
                modifier = Modifier
                    .background(
                        color = if (isCurrentIndex) UIColors.primaryBrand4 else UIColors.primaryBrand100,
                        shape = RoundedCornerShape(20)
                    )
                    .width(32.dp)
                    .height(4.dp)
            )
        }
    }
}

@Composable
fun NavigationButton(action: () -> Unit = {}, text: String, alignment: Alignment) {
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
                elevation = 0,
                action = { action.invoke() }
            )
        )
    }
}

@Composable
fun OnboardingTitle(title: String, sub: String, icon: Int) {
    val inlineImage = InlineTextContent(
        placeholder = Placeholder(
            width = 50.sp,
            height = 50.sp,
            placeholderVerticalAlign = PlaceholderVerticalAlign.TextCenter
        ),
        children = {
            CustomFlexibleImage(
                modifier = Modifier.fillMaxSize(),
                uiModel = FlexibleImageUIModel(
                    imageSource = FlexibleImageSource(
                        painter = painterResource(icon)
                    )
                )
            )

        }
    )

    val annotatedText = buildAnnotatedString {

        withStyle(
            style = SpanStyle(
                color = UIColors.white,
                fontSize = 24.sp,
                fontWeight = FontWeight.SemiBold
            )
        ) {
            append(title)
        }

        append(" ")

        append(sub)

        appendInlineContent("image", "[Image]")

    }
    Box(modifier = Modifier.width(223.dp)) {
        Text(
            text = annotatedText,
            style = TextStyle(
                color = UIColors.grayscale_300,
                fontSize = 24.sp,
                fontWeight = FontWeight.Medium
            ),
            textAlign = TextAlign.Center,
            inlineContent = mapOf("image" to inlineImage)
        )
    }
}
