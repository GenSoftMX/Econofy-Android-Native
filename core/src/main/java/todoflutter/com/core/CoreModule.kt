package todoflutter.com.core

import android.content.Context
import com.google.firebase.FirebaseApp
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.crashlytics.FirebaseCrashlytics
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import todoflutter.com.core.preferences.Preferences
import todoflutter.com.core.preferences.PreferencesImpl
import javax.inject.Singleton

/**
 * CoreModule: Provides Firebase services as singletons for the application.
 * This module ensures proper initialization and dependency injection for Firebase components.
 */
@Module
@InstallIn(SingletonComponent::class)
class CoreModule {

    /**
     * Provides a singleton instance of FirebaseApp.
     * Initializes FirebaseApp if not already initialized.
     *
     * @param context Application context.
     * @return An instance of FirebaseApp.
     * @throws IllegalStateException if initialization fails.
     */
    @Provides
    @Singleton
    fun provideFirebaseApp(@ApplicationContext context: Context): FirebaseApp {
        return FirebaseApp.initializeApp(context)
            ?: throw IllegalStateException("FirebaseApp failed to initialize.")
    }

    /**
     * Provides a singleton instance of FirebaseAnalytics.
     *
     * @param context Application context.
     * @return An instance of FirebaseAnalytics.
     */
    @Provides
    @Singleton
    fun provideFirebaseAnalytics(@ApplicationContext context: Context): FirebaseAnalytics {
        return FirebaseAnalytics.getInstance(context)
    }

    /**
     * Provides a singleton instance of FirebaseCrashlytics.
     *
     * @return An instance of FirebaseCrashlytics.
     */
    @Provides
    @Singleton
    fun provideFirebaseCrashlytics(): FirebaseCrashlytics {
        return FirebaseCrashlytics.getInstance()
    }

    /**
     * Provides a singleton instance of Preferences.
     * Preferences is an abstraction over SharedPreferences, making it easier to manage app settings.
     *
     * @param context Application context.
     * @return An instance of Preferences implemented by PreferencesImpl.
     */
    @Provides
    @Singleton
    fun providePreferences(@ApplicationContext context: Context): Preferences {
        return PreferencesImpl(context)
    }
}
