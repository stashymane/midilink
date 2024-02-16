package dev.stashy.midilink.model

import androidx.compose.runtime.compositionLocalOf
import kotlinx.serialization.Serializable

@Serializable
data class Settings(val theme: Theme = Theme.DARK, val appColor: ULong? = null) {
    enum class Theme {
        LIGHT, DARK
    }
}

val LocalSettings = compositionLocalOf { Settings() }
