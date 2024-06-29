plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.jetbrainsCompose)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.kotlinx.serialization)
}

kotlin {
    jvm()

    sourceSets {
        commonMain.dependencies {
            implementation(libs.bundles.model)
            implementation(projects.model)
            implementation(libs.bundles.midifunk)

            implementation(compose.runtime)
            implementation(compose.foundation)
//            implementation(compose.material3)
//            implementation(compose.ui)
//            implementation(compose.components.resources)
//            implementation(compose.components.uiToolingPreview)

            implementation(libs.bundles.ktor.client)
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}
