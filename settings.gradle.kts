@file:Suppress("UnstableApiUsage")

include(
    ":app",
    ":feature-game:data",
    ":feature-game:presentation",
    ":feature-main-menu:presentation",
    ":feature-settings:presentation",
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