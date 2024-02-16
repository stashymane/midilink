package dev.stashy.midilink.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.materialkolor.AnimatedDynamicMaterialTheme

@Composable
fun AppTheme(seedColor: Color? = null, isDark: Boolean = true, content: @Composable () -> Unit) {
    AnimatedDynamicMaterialTheme(seedColor ?: Color.Blue, isDark, content = content)
}
