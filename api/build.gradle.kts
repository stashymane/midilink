plugins {
    kotlin("jvm")
    id("org.jetbrains.compose")
    alias(libs.plugins.serialization)
}

dependencies {
    implementation(libs.ktx.coroutines)
    implementation(libs.ktx.serialization.json)
    implementation(libs.midifunk.events)
    implementation(libs.midifunk.devices)
}
