package todoflutter.com.econofy.ui.onboarding

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import todoflutter.com.econofy.feature.onboarding.ui.OnboardingView
import todoflutter.com.econofy.ui.extensions.LocalizedStrings

class OnboardingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        LocalizedStrings.initialize(this)

        setContent {
            OnboardingView()
        }
    }
}
