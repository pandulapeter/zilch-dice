"VERSION_NAME" set "1.0.0"
"VERSION_CODE" set 1
"KEY_ALIAS" set "androiddebugkey"
"KEY_PASSWORD" set "android"
"STORE_FILE" set "internal.keystore"
"STORE_PASSWORD" set "android"
"TARGET_SDK_VERSION" set 34
"MIN_SDK_VERSION" set 28

infix fun String.set(value: Any) = System.setProperty(this, value.toString())

plugins {
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.androidLibrary) apply false
    alias(libs.plugins.jetbrainsCompose) apply false
    alias(libs.plugins.kotlinMultiplatform) apply false
    alias(libs.plugins.moko) apply false
}
buildscript {
    dependencies {
        classpath(libs.moko.generator)
    }
}