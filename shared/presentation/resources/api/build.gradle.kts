plugins {
    id("kotlin")
    alias(libs.plugins.jetbrainsCompose)
}

dependencies {
    api(compose.foundation)
}