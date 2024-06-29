package platform

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.window.WindowDraggableArea
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.FrameWindowScope
import androidx.compose.ui.window.WindowPlacement
import androidx.compose.ui.window.WindowState

interface WindowControls {
    @Composable
    fun windowDragArea(modifier: Modifier, content: @Composable () -> Unit): Unit

    fun minimize(): Unit
    fun maximize(): Unit
    fun close(): Unit

    object NoOp : WindowControls {
        @Composable
        override fun windowDragArea(modifier: Modifier, content: @Composable () -> Unit) =
            Row(modifier = modifier) {
                content()
            }

        override fun minimize() {
        }

        override fun maximize() {
        }

        override fun close() {
        }
    }
}

fun FrameWindowScope.getControls(state: WindowState, onClose: () -> Unit): WindowControls {
    return object : WindowControls {
        @Composable
        override fun windowDragArea(modifier: Modifier, content: @Composable () -> Unit) =
            WindowDraggableArea(modifier, content)

        override fun minimize() {
            state.isMinimized = true
        }

        override fun maximize() {
            state.placement = when (state.placement) {
                WindowPlacement.Floating -> WindowPlacement.Maximized
                else -> WindowPlacement.Floating
            }
        }

        override fun close() = onClose()

    }
}

val LocalWindowControls: ProvidableCompositionLocal<WindowControls> = staticCompositionLocalOf { WindowControls.NoOp }
