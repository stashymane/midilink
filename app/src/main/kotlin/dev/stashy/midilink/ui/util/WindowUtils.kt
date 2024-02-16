package dev.stashy.midilink.ui.util

import androidx.compose.ui.window.WindowPlacement
import androidx.compose.ui.window.WindowState

fun WindowState.toggleMaximized() {
    placement = when (placement) {
        WindowPlacement.Floating -> WindowPlacement.Maximized
        else -> WindowPlacement.Floating
    }
}

fun WindowState.toggleMinimized() {
    isMinimized = !isMinimized
}
