import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.androidLibrary)
    id("kotlin-android")
}

dependencies {
    implementation(libs.androidx.appCompat)
    debugImplementation(project(":utilities:logger"))
    debugImplementation(libs.beagle)
    debugImplementation(libs.beagle.crashLogger)
}
kotlin {
    compilerOptions.jvmTarget.set(JvmTarget.JVM_1_8)
}

android {
    val targetSdkVersion = System.getProperty("TARGET_SDK_VERSION").toInt()
    compileSdk = targetSdkVersion
    defaultConfig.minSdk = System.getProperty("MIN_SDK_VERSION").toInt()
    namespace = "com.pandulapeter.zilchDice.shared.presentation.debugMenuAndroid"
}