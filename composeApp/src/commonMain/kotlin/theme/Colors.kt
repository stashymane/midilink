package theme

import androidx.compose.material3.ColorScheme
import androidx.compose.ui.graphics.Color

val ColorScheme.border: Color
    get() = onSurface.copy(alpha = 0.1f)