package theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.InternalComposeUiApi
import androidx.compose.ui.LocalSystemTheme
import androidx.compose.ui.SystemTheme
import androidx.compose.ui.graphics.Color
import com.materialkolor.DynamicMaterialTheme
import com.materialkolor.DynamicMaterialThemeState
import com.materialkolor.rememberDynamicMaterialThemeState

@OptIn(InternalComposeUiApi::class)
@Composable
fun AppTheme(
    state: DynamicMaterialThemeState = rememberDynamicMaterialThemeState(
        Color.Blue,
        LocalSystemTheme.current == SystemTheme.Dark
    ),
    content: @Composable () -> Unit
) {
    DynamicMaterialTheme(state, animate = true, content = content)
}