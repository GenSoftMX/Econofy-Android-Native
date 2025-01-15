package todoflutter.com.econofy

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import todoflutter.com.econofy.ui.extensions.LocalizedStrings

@HiltAndroidApp
class MainActivity : Application(){
    override fun onCreate() {
        super.onCreate()

        LocalizedStrings.initialize(this)
    }
}
