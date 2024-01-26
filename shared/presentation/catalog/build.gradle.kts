plugins {
    id("kotlin")
    alias(libs.plugins.jetbrainsCompose)
}

dependencies {
    api(compose.desktop.currentOs)
    implementation(project(":shared:presentation:resources:api"))
}