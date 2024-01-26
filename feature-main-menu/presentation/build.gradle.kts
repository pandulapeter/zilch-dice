plugins {
    id("kotlin")
    alias(libs.plugins.jetbrainsCompose)
}

dependencies {
    api(compose.desktop.currentOs)
    implementation(libs.koin.core)
    implementation(project(":shared:presentation:catalog"))
    implementation(project(":shared:presentation:resources:api"))
}