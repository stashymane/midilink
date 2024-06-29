plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.kotlinx.serialization)
}

kotlin {
    jvm()

    sourceSets {
        commonMain.dependencies {
            implementation(projects.model)
            implementation(libs.bundles.model)
            implementation(libs.bundles.midifunk)
            implementation(libs.bundles.ktor.client)
        }
    }
}
