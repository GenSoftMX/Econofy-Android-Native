package todoflutter.com.econofy.feature.splash

import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.compose.runtime.DisposableEffect
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import todoflutter.com.econofy.feature.splash.ui.SplashScreenView
import dagger.hilt.android.AndroidEntryPoint
import todoflutter.com.core.preferences.Preferences
import todoflutter.com.econofy.feature.onboarding.OnboardingActivity
import todoflutter.com.econofy.ui.authentication.AuthenticationActivity
import javax.inject.Inject

/**
 * SplashViewActivity is the entry point activity that determines whether to navigate
 * to the onboarding screen or the authentication screen based on the user's first-time usage.
 *
 * This activity observes the lifecycle of the application and triggers the necessary navigation
 * once the application resumes (on `ON_RESUME` event).
 *
 * Dependency injection is used to obtain the preferences instance, which is checked
 * to determine the first-time app usage.
 */
@AndroidEntryPoint
class SplashViewActivity : AppCompatActivity() {


    // Injecting the preferences object to check if the user is opening the app for the first time
    @Inject
    lateinit var preferences: Preferences

    /**
     * Called when the activity is created. Sets up the content view and observes the lifecycle
     * of the activity to trigger the navigation logic when the activity is resumed.
     *
     * @param savedInstanceState The saved instance state bundle passed by the system during activity creation.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Observer to listen for the ON_RESUME event and trigger the init logic
        val observer = LifecycleEventObserver { _, event ->
            if (event == Lifecycle.Event.ON_RESUME) {
                init()  // Trigger navigation logic when the activity resumes
            }
        }

        // Set the Composable content and register the observer for the lifecycle event
        setContent {
            SplashScreenView()

            DisposableEffect(Unit) {
                // Adding the observer to the lifecycle
                lifecycle.addObserver(observer)

                // Removing the observer when the Composable is disposed
                onDispose {
                    lifecycle.removeObserver(observer)
                }
            }
        }
    }

    /**
     * Initializes the navigation logic based on the app's state.
     * It checks if the user is opening the app for the first time and navigates accordingly.
     */
    private fun init() {
        when (preferences.isFirstOpened) {
            true -> {
                // Navigate to the onboarding screen if the user is opening the app for the first time
                OnboardingActivity.newInstance(this)
            }
            else -> {
                // Navigate to the authentication screen if the user has already opened the app
                AuthenticationActivity.newInstance(this)
            }
        }
    }
}
