plugins {
    alias(libs.plugins.androidLibrary)
    id("kotlin-android")
}

dependencies {
    implementation(libs.androidx.appCompat)
    debugImplementation(libs.beagle)
    debugImplementation(libs.beagle.crashLogger)
    debugImplementation(project(":utilities:logger"))
}

android {
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    val targetSdkVersion = System.getProperty("TARGET_SDK_VERSION").toInt()
    compileSdk = targetSdkVersion
    defaultConfig.minSdk = System.getProperty("MIN_SDK_VERSION").toInt()
    namespace = "com.pandulapeter.zilchDice.shared.presentation.debugMenuAndroid"
}