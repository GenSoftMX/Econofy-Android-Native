plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.hilt) apply false
    alias(libs.plugins.org.jetbrains.kotlin.kapt) apply false
    alias(libs.plugins.firebase.crashlytics)  apply false
    alias(libs.plugins.firebase.distribution) apply false
}

buildscript {
    extra.apply {
        set("versionCode", "1")
        set("version", "1.0.0")
    }
}