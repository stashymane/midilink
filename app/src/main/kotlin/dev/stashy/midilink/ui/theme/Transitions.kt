package dev.stashy.midilink.ui.theme

import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut

fun appear() = fadeIn() + scaleIn(initialScale = 0.8f)
fun disappear() = fadeOut() + scaleOut(targetScale = 0.8f)
