import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    kotlin("jvm")
    id("org.jetbrains.compose")
    alias(libs.plugins.serialization)
}

dependencies {
    implementation(project(":api"))

    implementation(libs.ktx.serialization.json)
    implementation(libs.midifunk.events)
    implementation(libs.midifunk.devices)

    implementation(compose.desktop.currentOs) {
        exclude(compose.material)
    }

    implementation(compose.material3)
    implementation(compose.materialIconsExtended)

    implementation(libs.materialKolor)
    implementation(libs.kmpalette.core)
    implementation(libs.kmpalette.extensions.resources)
}

compose.desktop {
    application {
        mainClass = "dev.stashy.midilink.MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "midilink"
            packageVersion = "1.0.0"
        }
    }
}
