plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.hilt)
    alias(libs.plugins.org.jetbrains.kotlin.kapt)
    alias(libs.plugins.google.services)
    alias(libs.plugins.firebase.crashlytics)
    alias(libs.plugins.firebase.distribution)
}

android {
    namespace = "todoflutter.com.econofy"
    compileSdk = 35

    buildFeatures {
        compose = true
    }

    defaultConfig {
        applicationId = "todoflutter.com.econofy"
        minSdk = 28
        targetSdk = 35
        versionCode = (rootProject.extra.get("versionCode") as String).substringBefore(".").toInt()
        versionName = rootProject.extra.get("version") as String

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}



dependencies {
    implementation(project(":ui"))
    implementation(project(":core"))

    implementation(libs.androidx.foundation.android)
    implementation(libs.androidx.material3.android)
    implementation(libs.androidx.ui.tooling.preview.android)
    implementation(libs.material)

    implementation(libs.hilt.android)
    debugImplementation(libs.androidx.ui.tooling)
    kapt(libs.hilt.compiler)
    implementation(libs.androidx.hilt.navigation.compose)

    implementation(libs.androidx.appcompat)
    implementation(libs.firebase.common.ktx)
    implementation(libs.firebase.crashlytics.ktx)
    implementation(libs.google.gson)
    implementation(platform(libs.firebase.bom))
    implementation(libs.firebase.analityc)


    // Activity Compose
    implementation(libs.androidx.activity.compose)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}

kapt {
    correctErrorTypes = true
}
