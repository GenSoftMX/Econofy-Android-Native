package todoflutter.com.econofy.ui.main

import android.app.Application
import todoflutter.com.econofy.ui.extensions.LocalizedStrings

class MainActivity : Application() {

    override fun onCreate() {
        super.onCreate()

        LocalizedStrings.initialize(this)
    }
}
