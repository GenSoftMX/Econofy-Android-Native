package todoflutter.com.econofy.feature.onboarding.domain.models.usecases

import todoflutter.com.econofy.R
import todoflutter.com.econofy.ui.extensions.LocalizedStrings

data class OnboardingModel(
    val asset: Int,
    val title: String,
    val sub: String,
    val body: String,
    val icon: Int
) {
    companion object {
        val data: List<OnboardingModel> = listOf(
            OnboardingModel(
                title = LocalizedStrings.onboarding1Title,
                sub = LocalizedStrings.onboarding1Sub,
                body = LocalizedStrings.onboarding1Body,
                icon = R.drawable.ok,
                asset = R.drawable.onboarding_1
            ), OnboardingModel(
                title = LocalizedStrings.onboarding2Title,
                sub = LocalizedStrings.onboarding2Sub,
                body = LocalizedStrings.onboarding2Body,
                icon = R.drawable.hand_2,
                asset = R.drawable.onboarding_2
            )
        )
    }
}
