plugins {
    kotlin("jvm")
    id("org.jetbrains.compose")
}

dependencies {
    api(libs.ktx.coroutines)
    api(libs.midifunk.events)
    api(libs.midifunk.devices)
    api(compose.runtime)
}
