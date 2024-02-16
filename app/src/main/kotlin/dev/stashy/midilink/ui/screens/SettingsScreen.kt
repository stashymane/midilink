package dev.stashy.midilink.ui.screens

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import dev.stashy.midilink.model.LocalSettings
import dev.stashy.midilink.model.Settings
import dev.stashy.midilink.ui.components.Item
import dev.stashy.midilink.ui.components.ItemDropdown
import dev.stashy.midilink.ui.theme.AppTheme

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun SettingsScreen(onUpdate: (Settings) -> Unit = {}) {
    val scrollState = rememberScrollState()
    val settings = LocalSettings.current

    Column(Modifier.padding(16.dp).verticalScroll(scrollState).fillMaxSize()) {
        FlowRow {
            Column {
                Text("Theme")

                ItemDropdown({ Text(settings.theme.name) }) {
                    Settings.Theme.entries.forEach {
                        Item({ Text(it.name) }, onClick = { onUpdate(settings.copy(theme = it)) })
                    }
                }
            }

            Column {
                Text("Color")

                Row {
                    listOf(Color.Red, Color.Blue, Color.Green, Color.Magenta, Color.Yellow).forEach {
                        Card(
                            Modifier.size(24.dp).clickable { onUpdate(settings.copy(appColor = it.value)) },
                            shape = RoundedCornerShape(4.dp),
                            colors = CardDefaults.cardColors(containerColor = it)
                        ) {}
                    }
                }
                TextButton({ onUpdate(settings.copy(appColor = null)) }) {
                    Text("Reset")
                }
            }
        }
    }
}

@Preview
@Composable
private fun SettingsScreenPreview() {
    AppTheme {
        SettingsScreen()
    }
}
