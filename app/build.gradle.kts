plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    kotlin("kapt")

}

android {
    namespace = "com.example.tp4"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.tp4"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.room.common)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.8.6")
    //implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:2.4.0")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.0")
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.google.code.gson:gson:2.10.1")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation ("androidx.room:room-runtime: 2.5.0")
    kapt ("androidx.room:room-compiler:2.5.0")
    implementation ("androidx.room:room-ktx:2.5.0")

    // Koin core for Android
    implementation ("io.insert-koin:koin-android:3.4.0")

    // Koin for ViewModel (integrated within koin-android from v3.4.0)
    implementation ("io.insert-koin:koin-androidx-navigation:3.4.0" )// Optional, if using Koin with Jetpack Navigation

    // Koin for Jetpack Compose (optional, if using Compose)
    implementation ("io.insert-koin:koin-androidx-compose:3.4.0")

}
kapt {
    correctErrorTypes = true
}