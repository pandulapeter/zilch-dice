plugins {
    id("kotlin")
    alias(libs.plugins.jetbrainsCompose)
}

dependencies {
    api(compose.desktop.currentOs)
}