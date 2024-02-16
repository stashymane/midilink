plugins {
    kotlin("jvm") apply false
    id("org.jetbrains.compose") apply false
    alias(libs.plugins.serialization) apply false
}

group = "dev.stashy"
version = "0.1.0-SNAPSHOT"
