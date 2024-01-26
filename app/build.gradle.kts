import org.jetbrains.compose.ExperimentalComposeLibrary
import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsCompose)
}

kotlin {
    androidTarget().compilations.all {
        kotlinOptions.jvmTarget = JvmTarget.JVM_1_8.target
    }
    jvm("desktop")
    sourceSets {
        val desktopMain by getting
        androidMain.dependencies {
            implementation(libs.androidx.activityCompose)
            implementation(libs.google.material)
            implementation(libs.koin.android)
            implementation(project(":shared:presentation:debug-menu-android"))
        }
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material)
            implementation(compose.ui)
            @OptIn(ExperimentalComposeLibrary::class)
            implementation(compose.components.resources)
            implementation(libs.koin.core)
            implementation(project(":feature-main-menu:presentation"))
            implementation(project(":feature-game:presentation"))
            implementation(project(":shared:presentation:catalog"))
            implementation(project(":shared:presentation:resources:implementation"))
            implementation(project(":shared:presentation:navigator"))
            implementation(project(":utilities:logger"))
            implementation(project(":utilities:extensions"))
        }
        desktopMain.dependencies {
            implementation(compose.desktop.currentOs)
        }
    }
}

val versionNameString = System.getProperty("VERSION_NAME").orEmpty()
val packageNameString = "com.pandulapeter.zilchDice"

android {
    namespace = "com.pandulapeter.zilchDice"
    val targetSdkVersion = System.getProperty("TARGET_SDK_VERSION").toInt()
    compileSdk = targetSdkVersion
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    sourceSets["main"].res.srcDirs("src/androidMain/res")
    sourceSets["main"].resources.srcDirs("src/commonMain/resources")
    defaultConfig {
        applicationId = packageNameString
        minSdk = System.getProperty("MIN_SDK_VERSION").toInt()
        targetSdk = targetSdkVersion
        versionCode = System.getProperty("VERSION_CODE").toInt()
        versionName = versionNameString
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    val internalSigningConfig = "internal"
    val releaseSigningConfig = "release"
    signingConfigs {
        create(internalSigningConfig) {
            keyAlias = "androiddebugkey"
            keyPassword = "android"
            storeFile = file("internal.keystore")
            storePassword = "android"
        }
        create(releaseSigningConfig) {
            keyAlias = System.getProperty("KEY_ALIAS")
            keyPassword = System.getProperty("KEY_PASSWORD")
            storeFile = file(System.getProperty("STORE_FILE"))
            storePassword = System.getProperty("STORE_PASSWORD")
        }
    }
    buildTypes {
        debug {
            isDebuggable = true
            isMinifyEnabled = false
            isShrinkResources = false
            versionNameSuffix = "-debug"
            applicationIdSuffix = ".debug"
            signingConfig = signingConfigs.getByName(internalSigningConfig)
        }
        release {
            isDebuggable = false
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
            signingConfig = signingConfigs.getByName(releaseSigningConfig)
        }
    }
}

compose.desktop {
    application {
        mainClass = "com.pandulapeter.zilchDice.ZilchDiceDesktopAppKt"
        buildTypes.release.proguard {
            configurationFiles.from(project.file("proguard-rules.pro"))
            obfuscate.set(true)
        }
        mainClass = "com.pandulapeter.zilchDice.ZilchDiceDesktopApplicationKt"
        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Exe, TargetFormat.Msi, TargetFormat.Deb)
            packageName = packageNameString
            packageVersion = versionNameString
            version = versionNameString
            description = "Zilch Dice"
            copyright = "©2024 Pandula Péter. All rights reserved."
            vendor = "Pandula Péter"
            licenseFile.set(project.file("LICENSE.txt"))
            macOS {
                iconFile.set(project.file("appIcon.icns"))
            }
            windows {
                iconFile.set(project.file("appIcon.ico"))
            }
            linux {
                iconFile.set(project.file("appIcon.png"))
            }
        }
    }
}
