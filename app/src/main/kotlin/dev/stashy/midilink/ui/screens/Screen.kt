package dev.stashy.midilink.ui.screens

import dev.stashy.midilink.model.DeviceFlow

sealed class Screen() {
    data object Home : Screen()
    data class Flow(val flow: DeviceFlow) : Screen()
    data object Settings : Screen()
}
