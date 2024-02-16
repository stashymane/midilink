package dev.stashy.midilink.ui.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import dev.stashy.midilink.model.DeviceFlow
import dev.stashy.midilink.ui.screens.Screen
import dev.stashy.midilink.ui.theme.AppTheme

@Composable
fun Sidebar(
    currentScreen: Screen? = null,
    flows: List<DeviceFlow>,
    onClick: (DeviceFlow) -> Unit,
    onSettings: () -> Unit,
    onNewFlow: () -> Unit,
    modifier: Modifier = Modifier,
    width: Dp = 200.dp
) {
    val listState = rememberLazyListState()

    Column(modifier.width(width).fillMaxHeight()) {
        Row(
            Modifier.fillMaxWidth().padding(start = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Flows", fontWeight = FontWeight.Bold, fontSize = 0.8.em)
            IconButton(onNewFlow) {
                Icon(Icons.Default.Add, "Add new flow")
            }
        }
        LazyColumn(Modifier.weight(1f), listState) {
            items(flows) {
                SidebarItem(
                    (currentScreen as? Screen.Flow)?.flow == it,
                    { Text(it.name) },
                    { onClick(it) })
            }
        }

        SidebarItem(
            currentScreen is Screen.Settings,
            {
                Icon(Icons.Default.Settings, null)
                Text("Settings")
            },
            onSettings
        )
    }
}

@Composable
private fun SidebarItem(isActive: Boolean = false, text: @Composable () -> Unit, onClick: () -> Unit) {
    val backgroundColor by animateColorAsState(MaterialTheme.colorScheme.primaryContainer.copy(alpha = if (isActive) 0.4f else 0f))
    val contentColor by animateColorAsState(if (isActive) MaterialTheme.colorScheme.onPrimaryContainer else MaterialTheme.colorScheme.onSurface)

    Row(
        Modifier.background(backgroundColor).clickable(onClick = onClick, role = Role.Tab)
            .padding(12.dp).fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        text()
    }
}

@Preview
@Composable
private fun SidebarPreview() {
    AppTheme {
        Sidebar(null, listOf(DeviceFlow("Flow 1"), DeviceFlow("Flow 2")), {}, {}, {})
    }
}
