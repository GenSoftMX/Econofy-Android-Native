package todoflutter.com.econofy.feature.authentication.sign_up.ui

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import todoflutter.com.ui.foundation.text.model.TextUIModel
import todoflutter.com.ui.foundation.text.ui.CustomText

@Composable
fun SignUpView(
    navController: NavHostController,
    activity: Activity
){
    CustomText(uiModel = TextUIModel(text = "SignUpView"))
}