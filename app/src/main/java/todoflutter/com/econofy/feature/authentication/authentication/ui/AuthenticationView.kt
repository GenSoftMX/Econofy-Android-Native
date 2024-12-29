package todoflutter.com.econofy.feature.authentication.authentication.ui

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import todoflutter.com.ui.foundation.text.model.TextUIModel
import todoflutter.com.ui.foundation.text.ui.CustomText

@Composable
fun AuthenticationView(
    navController: NavHostController,
    activity: Activity
){
    CustomText(uiModel = TextUIModel(text = "AuthenticationView"))
}