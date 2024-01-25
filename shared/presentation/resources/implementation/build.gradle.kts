import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.jetbrainsCompose)
    alias(libs.plugins.moko)
}

kotlin {
    androidTarget().compilations.all {
        kotlinOptions.jvmTarget = JvmTarget.JVM_1_8.target
    }
    jvm("desktop")
    sourceSets {
        val desktopMain by getting
        androidMain {
            dependsOn(commonMain.get())
        }
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(libs.moko)
            api(project(":shared:presentation:resources:api"))
            api(libs.koin.core)
        }
        desktopMain.dependencies {
            implementation(compose.desktop.currentOs)
        }
        desktopMain.dependsOn(commonMain.get())
    }
}

android {
    namespace = "com.pandulapeter.zilchDice.shared.presentation.resources.implementation"
    val targetSdkVersion = System.getProperty("TARGET_SDK_VERSION").toInt()
    compileSdk = targetSdkVersion
    defaultConfig.minSdk = System.getProperty("MIN_SDK_VERSION").toInt()
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    sourceSets["main"].res.srcDirs("src/androidMain/res", "src/commonMain/resources")
    sourceSets["main"].resources.srcDirs("src/commonMain/resources")
}

multiplatformResources {
    multiplatformResourcesPackage = android.namespace
}