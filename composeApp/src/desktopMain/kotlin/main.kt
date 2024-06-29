import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import platform.LocalWindowControls
import platform.getControls
import java.awt.Dimension

fun main() = application {
    val windowState = rememberWindowState()
    Window(
        state = windowState,
        onCloseRequest = ::exitApplication,
        title = "midilink",
        undecorated = true,
        transparent = true
    ) {
        window.minimumSize = Dimension(600, 400)
        CompositionLocalProvider(LocalWindowControls provides getControls(windowState, ::exitApplication)) {
            App()
        }
    }
}