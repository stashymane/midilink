package screens

import LocalAppSettings
import Settings
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import components.DropdownSwitch
import midilink.composeapp.generated.resources.Res
import midilink.composeapp.generated.resources.settings_theme
import midilink.composeapp.generated.resources.settings_theme_color
import midilink.composeapp.generated.resources.tab_settings
import org.jetbrains.compose.resources.stringResource
import theme.AppTheme

@Composable
fun SettingsScreen(onUpdate: (Settings) -> Unit) {
    val settings = LocalAppSettings.current

    Column(modifier = Modifier.fillMaxSize().padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Text(stringResource(Res.string.tab_settings), style = MaterialTheme.typography.headlineLarge)

        SingleSetting(stringResource(Res.string.settings_theme)) {
            DropdownSwitch(
                Settings.Theme.entries,
                settings.theme,
                { onUpdate(settings.copy(theme = it ?: Settings.Theme.SYSTEM)) }) {
                Text(stringResource(it.resource))
            }
        }

        SingleSetting(stringResource(Res.string.settings_theme_color)) {
            Column {
                Row(horizontalArrangement = Arrangement.spacedBy(2.dp)) {
                    listOf(Color.Red, Color.Blue, Color.Green, Color.Magenta, Color.White).forEach {
                        Box(Modifier.size(16.dp).clip(RoundedCornerShape(4.dp)).background(it)
                            .clickable { onUpdate(settings.copy(color = it.value)) })
                    }
                }
                Text("TODO color picker wheel")
            }
        }
    }
}

@Composable
fun SingleSetting(title: String, control: @Composable () -> Unit) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(title)
        Spacer(Modifier.width(4.dp))
        control()
    }
}

@Preview
@Composable
private fun SettingsScreenPreview() {
    AppTheme {
        SettingsScreen {}
    }
}
