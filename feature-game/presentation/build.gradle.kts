plugins {
    id("kotlin")
    alias(libs.plugins.jetbrainsCompose)
}

dependencies {
    api(compose.desktop.currentOs)
    implementation(libs.koin.core)
    implementation(project(":feature-game:data"))
    implementation(project(":shared:presentation:catalog"))
    implementation(project(":shared:presentation:navigator"))
    implementation(project(":shared:presentation:resources:api"))
    implementation(project(":utilities:extensions"))
    implementation(project(":utilities:logger"))
}