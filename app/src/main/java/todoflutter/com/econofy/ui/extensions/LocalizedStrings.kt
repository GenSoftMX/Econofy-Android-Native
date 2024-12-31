package todoflutter.com.econofy.ui.extensions

import android.annotation.SuppressLint
import android.content.Context
import todoflutter.com.econofy.R

@SuppressLint("StaticFieldLeak")
object LocalizedStrings {
    lateinit var context: Context

    fun initialize(appContext: Context) {
        context = appContext
    }

    val onboarding1Title: String
        get() = context.getString(R.string.onboarding1_title)

    val onboarding1Sub: String
        get() = context.getString(R.string.onboarding1_sub)

    val onboarding1Body: String
        get() = context.getString(R.string.onboarding1_body)

    val onboarding2Title: String
        get() = context.getString(R.string.onboarding2_title)

    val onboarding2Sub: String
        get() = context.getString(R.string.onboarding2_sub)

    val onboarding2Body: String
        get() = context.getString(R.string.onboarding2_body)
}
