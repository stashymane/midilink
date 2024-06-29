package theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.materialkolor.DynamicMaterialTheme
import com.materialkolor.DynamicMaterialThemeState
import com.materialkolor.rememberDynamicMaterialThemeState

@Composable
fun AppTheme(
    state: DynamicMaterialThemeState = rememberDynamicMaterialThemeState(Color.Blue, true),
    content: @Composable () -> Unit
) {
    DynamicMaterialTheme(state, animate = true, content = content)
}