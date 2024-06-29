package components

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import midilink.composeapp.generated.resources.Res
import midilink.composeapp.generated.resources.tab_event_log
import midilink.composeapp.generated.resources.tab_home
import midilink.composeapp.generated.resources.tab_settings
import org.jetbrains.compose.resources.stringResource
import theme.AppTheme
import theme.rememberRightTooltipPositionProvider


@Composable
fun Sidebar(modifier: Modifier = Modifier) {
    val navigator = LocalNavController.current
    var sidebarExpanded by remember { mutableStateOf(false) }
    val width by animateDpAsState(if (sidebarExpanded) 128.dp else 48.dp)

    Box {
        Column(modifier = modifier.width(width).fillMaxHeight()) {
            SidebarItem(
                Icons.Default.Home,
                stringResource(Res.string.tab_home),
                sidebarExpanded
            ) { navigator.navigate("home") { launchSingleTop = true } }

            SidebarItem(
                Icons.AutoMirrored.Default.List,
                stringResource(Res.string.tab_event_log),
                sidebarExpanded
            ) { navigator.navigate("eventlog") { launchSingleTop = true } }

            Spacer(Modifier.weight(1f))

            SidebarItem(
                Icons.Default.Settings,
                stringResource(Res.string.tab_settings),
                sidebarExpanded
            ) { navigator.navigate("settings") { launchSingleTop = true } }
            SidebarItem(Icons.Default.ChevronRight, "Expand", sidebarExpanded) { sidebarExpanded = !sidebarExpanded }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SidebarItem(icon: ImageVector, title: String, expanded: Boolean, onClick: () -> Unit) {
    TooltipBox(
        positionProvider = rememberRightTooltipPositionProvider(8.dp),
        tooltip = { PlainTooltip { Text(title) } },
        state = rememberTooltipState()
    ) {
        IconButton(onClick) {
            Icon(icon, null)
//            AnimatedContent(expanded) {
//                when (it) {
//                    true -> Text(title)
//                    else -> {}
//                }
//            }
        }
    }
}

@Preview
@Composable
private fun SidebarPreview() {
    AppTheme {
        Sidebar()
    }
}