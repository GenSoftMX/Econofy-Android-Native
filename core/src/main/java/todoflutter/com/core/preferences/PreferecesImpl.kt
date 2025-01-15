package todoflutter.com.core.preferences

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import todoflutter.com.core.preferences.AppPreferencesKeys.FIRST_OPENED

/**
 * Implementation of the Preferences interface using SharedPreferences.
 * Provides an easy-to-use API for accessing and modifying app-level preferences.
 */
@Module
@InstallIn(SingletonComponent::class)
class PreferencesImpl(context: Context): Preferences {

    /**
     * Lazily initialized SharedPreferences instance.
     */
    private val preferences: SharedPreferences by lazy {
        context.getSharedPreferences("GB-sp", MODE_PRIVATE)
    }

    /**
     * Tracks if the app was opened for the first time.
     * Defaults to true if no value is set.
     */
    override var isFirstOpened: Boolean
        get() = preferences.getBoolean(FIRST_OPENED, true)
        set(value) = preferences.commitSafely { putBoolean(FIRST_OPENED, value) }
}

/**
 * Safely commits changes to SharedPreferences.
 * Ensures that modifications are applied without crashing the app.
 *
 * @param modifier A lambda to modify the SharedPreferences.Editor.
 */
inline fun SharedPreferences.commitSafely(modifier: SharedPreferences.Editor.() -> Unit) {
    try {
        val editor = this.edit()
        editor.modifier()
        editor.apply()
    } catch (e: Exception) {
        // Log or handle the exception appropriately
        e.printStackTrace()
    }
}
