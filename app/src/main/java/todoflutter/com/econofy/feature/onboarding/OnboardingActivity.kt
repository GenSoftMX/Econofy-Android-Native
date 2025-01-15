package todoflutter.com.econofy.feature.onboarding

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import todoflutter.com.econofy.feature.onboarding.ui.OnboardingView
import todoflutter.com.econofy.feature.onboarding.viewModel.OnboardingViewModel

import todoflutter.com.econofy.ui.extensions.LocalizedStrings

@AndroidEntryPoint
class OnboardingActivity : AppCompatActivity() {
    private val viewModel: OnboardingViewModel by viewModels()  // ViewModel is injected here

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            OnboardingView(viewModel)
        }
    }

    companion object {
        fun newInstance(
            context: Context
        ) {
            context.startActivity(Intent(context, OnboardingActivity::class.java))
        }
    }
}