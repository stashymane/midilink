import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.*
import androidx.compose.ui.InternalComposeUiApi
import androidx.compose.ui.LocalSystemTheme
import androidx.compose.ui.Modifier
import androidx.compose.ui.SystemTheme
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.materialkolor.rememberDynamicMaterialThemeState
import components.LocalNavController
import components.LocalSnackbarState
import components.Sidebar
import components.Topbar
import model.Graph
import model.device.DeviceManager
import screens.EventLogScreen
import screens.GraphEditScreen
import screens.HomeScreen
import screens.SettingsScreen
import theme.AppTheme
import theme.border

@OptIn(InternalComposeUiApi::class)
@Composable
fun App() {
    val graphs = buildList {
        repeat(10) {
            add(Graph("graph-$it", "Graph #$it", "test", listOf()))
        }
    }
    val midiDevices = DeviceManager.list()

    var appSettings by remember { mutableStateOf(Settings()) }

    val controller = rememberNavController()
    val snackbarState = remember { SnackbarHostState() }

    AppTheme(
        state = rememberDynamicMaterialThemeState(
            seedColor = Color(appSettings.color),
            isDark = when (appSettings.theme) {
                Settings.Theme.SYSTEM -> LocalSystemTheme.current == SystemTheme.Dark
                else -> appSettings.theme == Settings.Theme.DARK
            }
        )
    ) {
        CompositionLocalProvider(
            LocalNavController provides controller,
            LocalSnackbarState provides snackbarState,
            LocalAppSettings provides appSettings
        ) {
            Scaffold(
                modifier = Modifier.clip(MaterialTheme.shapes.medium),
                snackbarHost = { SnackbarHost(snackbarState) },
                topBar = {
                    Topbar()
                }) { contentPadding ->
                Row(Modifier.padding(contentPadding)) {
                    Sidebar()
                    Spacer(Modifier.fillMaxHeight().width(1.dp).background(MaterialTheme.colorScheme.border))

                    NavHost(
                        controller,
                        startDestination = "home",
                        enterTransition = { fadeIn() },
                        exitTransition = { fadeOut() },
                        popEnterTransition = { fadeIn() },
                        popExitTransition = { fadeOut() }) {
                        composable("home") {
                            HomeScreen(midiDevices)
                        }
                        composable("eventlog") {
                            EventLogScreen()
                        }
                        composable("edit/{id}") { navEntry ->
                            val id = navEntry.arguments?.getString("id")
                            GraphEditScreen(graphs.find { it.id == id })
                        }
                        composable("settings") {
                            SettingsScreen(onUpdate = { appSettings = it })
                        }
                    }
                }
            }
        }
    }
}