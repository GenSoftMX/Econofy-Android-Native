package todoflutter.com.econofy.ui.authentication

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import todoflutter.com.econofy.navigation.AuthenticationDestinations
import todoflutter.com.econofy.navigation.AuthenticationNavigation
import todoflutter.com.econofy.ui.extensions.ECONOFYKEYS

class AuthenticationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val initialLocation = intent.getStringExtra(START_DESTINATION)?.let {
            AuthenticationDestinations.fromKey(it)
        } ?: AuthenticationDestinations.Authentication

        setContent {
            AuthenticationNavigation(
                activity = this,
                initialLocation = initialLocation
            )
        }
    }

    companion object {
        const val START_DESTINATION = ECONOFYKEYS.AUTHENTICATION_LOCATION

        fun newInstance(
            context: Context,
            startDestination: AuthenticationDestinations = AuthenticationDestinations.Authentication
        ) {
            context.startActivity(Intent(context, AuthenticationActivity::class.java).apply {
                putExtra(START_DESTINATION, startDestination)

            })
        }
    }
}