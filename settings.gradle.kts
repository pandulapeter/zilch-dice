@file:Suppress("UnstableApiUsage")

include(
    ":app",
    ":shared:presentation:catalog",
    ":shared:presentation:debug-menu-android",
    ":shared:presentation:resources:api",
    ":shared:presentation:resources:implementation",
    ":utilities:logger"
)
rootProject.name = "ZilchDice"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
pluginManagement {
    repositories {
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}
dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}