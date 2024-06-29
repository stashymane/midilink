package theme

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.*
import androidx.compose.ui.window.PopupPositionProvider

@Composable
fun rememberRightTooltipPositionProvider(spacing: Dp): PopupPositionProvider {
    val tooltipAnchorSpacing = with(LocalDensity.current) {
        spacing.roundToPx()
    }
    return remember(tooltipAnchorSpacing) {
        object : PopupPositionProvider {
            override fun calculatePosition(
                anchorBounds: IntRect,
                windowSize: IntSize,
                layoutDirection: LayoutDirection,
                popupContentSize: IntSize
            ): IntOffset {
                val x = anchorBounds.right + tooltipAnchorSpacing
                val y = anchorBounds.center.y - (popupContentSize.height / 2)
                return IntOffset(x, y)
            }
        }
    }
}

@Composable
fun PreviewContainer(content: @Composable () -> Unit) {
    AppTheme {
        Surface(Modifier.fillMaxSize()) {
            Column(Modifier.padding(16.dp)) {
                content()
            }
        }
    }
}