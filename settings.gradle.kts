@file:Suppress("UnstableApiUsage")

include(
    ":app",
    ":feature-main-menu:presentation",
    ":feature-game:presentation",
    ":shared:presentation:catalog",
    ":shared:presentation:debug-menu-android",
    ":shared:presentation:navigator",
    ":shared:presentation:resources:api",
    ":shared:presentation:resources:implementation",
    ":utilities:extensions",
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