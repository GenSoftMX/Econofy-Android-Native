package todoflutter.com.econofy.navigation

import android.annotation.SuppressLint
import android.app.Activity
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import androidx.navigation.compose.NavHost
import todoflutter.com.econofy.feature.authentication.authentication.ui.AuthenticationView
import todoflutter.com.econofy.feature.authentication.forgot_password.ui.ForgotPasswordView
import todoflutter.com.econofy.feature.authentication.sign_up.ui.SignUpView

// Define AuthenticationDestinations destinations names and keys
enum class AuthenticationDestinations(val key: String) {
    Authentication("authentication"),
    SingUp("SignUp"),
    ForgotPassword("forgotPassword");

    companion object {
        fun fromKey(key: String): AuthenticationDestinations =
            entries.firstOrNull { it.key == key } ?: Authentication
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AuthenticationNavigation(
    initialLocation: AuthenticationDestinations = AuthenticationDestinations.Authentication,
    navController: NavHostController = rememberNavController(),
    activity: Activity
) {
    Scaffold {
        NavHost(
            navController = navController,
            startDestination = initialLocation.key
        ) {
            composable(AuthenticationDestinations.Authentication.key) {
                AuthenticationView(
                    navController,
                    activity
                )
            }
            composable(AuthenticationDestinations.SingUp.key) {
                SignUpView(
                    navController,
                    activity
                )
            }
            composable(AuthenticationDestinations.ForgotPassword.key) {
                ForgotPasswordView(
                    navController,
                    activity
                )
            }
        }
    }
}
