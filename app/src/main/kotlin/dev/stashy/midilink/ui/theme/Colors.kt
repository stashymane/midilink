package dev.stashy.midilink.ui.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.ui.graphics.compositeOver

val ColorScheme.surfaceAlt
    get() = onSurface.copy(alpha = 0.1f).compositeOver(surface)
