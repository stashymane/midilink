package dev.stashy.midilink

import androidx.compose.animation.*
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Tune
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.*
import dev.stashy.midilink.model.LocalSettings
import dev.stashy.midilink.model.Settings
import dev.stashy.midilink.flow.DeviceFlow
import dev.stashy.midilink.ui.components.Sidebar
import dev.stashy.midilink.ui.components.Topbar
import dev.stashy.midilink.ui.screens.FlowEditor
import dev.stashy.midilink.ui.screens.HomeScreen
import dev.stashy.midilink.ui.screens.Screen
import dev.stashy.midilink.ui.screens.SettingsScreen
import dev.stashy.midilink.ui.theme.AppTheme
import java.awt.Dimension

@Composable
@Preview
fun WindowScope.App(onCloseRequest: () -> Unit, windowState: WindowState) {
    var settings by remember { mutableStateOf(Settings()) }
    var currentScreen: Screen by remember { mutableStateOf(Screen.Home) }

    val deviceFlows: MutableList<DeviceFlow> = remember { mutableStateListOf() }

    var currentColor: Color? by remember { mutableStateOf(null) }
    val snackbarState = remember { SnackbarHostState() }

    val windowRounding = if (windowState.placement == WindowPlacement.Floating) 16.dp else 0.dp
    var sidebarWidth by remember { mutableStateOf(200.dp) } //TODO resizable sidebar

    AppTheme(seedColor = settings.appColor?.let { Color(it) }, isDark = settings.theme == Settings.Theme.DARK) {
        CompositionLocalProvider(LocalSettings provides settings) {
            Scaffold(
                modifier = Modifier.clip(RoundedCornerShape(windowRounding)),
                topBar = {
                    Topbar(
                        currentScreen != Screen.Home,
                        windowState,
                        { currentScreen = Screen.Home },
                        onCloseRequest
                    )
                },
                snackbarHost = { SnackbarHost(snackbarState) }
            ) { paddingValues ->
                Row(Modifier.padding(paddingValues)) {
                    Sidebar(
                        currentScreen,
                        deviceFlows,
                        { currentScreen = Screen.Flow(it) },
                        { currentScreen = Screen.Settings },
                        { deviceFlows += DeviceFlow("Flow") },
                        width = sidebarWidth
                    )

                    AnimatedContent(currentScreen,
                        transitionSpec = { fadeIn() + slideInVertically { -20 } togetherWith fadeOut() + slideOutVertically { 20 } }
                    ) {
                        when (it) {
                            is Screen.Home -> {
                                HomeScreen(deviceFlows, onFlowClick = { currentScreen = Screen.Flow(it) })
                            }

                            is Screen.Flow -> {
                                FlowEditor(it.flow)
                            }

                            is Screen.Settings -> {
                                SettingsScreen { settings = it }
                            }
                        }
                    }
                }
            }
        }
    }
}

fun main() = application {
    val state = rememberWindowState()
    val icon = rememberVectorPainter(Icons.Default.Tune)
    val trayState = rememberTrayState()

    if (state.isMinimized) {
        Tray(icon, trayState, tooltip = "midilink", onAction = {
            state.isMinimized = false
        }) {
            Item("Exit", onClick = ::exitApplication)
        }
    } else {
        Window(
            state = state,
            title = "midilink",
            icon = icon,
            onCloseRequest = ::exitApplication,
            undecorated = true,
            transparent = true
        ) {
            window.minimumSize = Dimension(400, 200)
            App(onCloseRequest = ::exitApplication, state)
        }
    }
}
