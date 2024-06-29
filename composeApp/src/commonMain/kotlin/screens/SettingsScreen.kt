package screens

import AppSettings
import LocalAppSettings
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import midilink.composeapp.generated.resources.Res
import midilink.composeapp.generated.resources.settings_theme_color
import midilink.composeapp.generated.resources.settings_theme_dark
import midilink.composeapp.generated.resources.tab_settings
import org.jetbrains.compose.resources.stringResource
import theme.AppTheme

@Composable
fun SettingsScreen(onUpdate: (AppSettings) -> Unit) {
    val settings = LocalAppSettings.current

    Column(modifier = Modifier.fillMaxSize().padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Text(stringResource(Res.string.tab_settings), style = MaterialTheme.typography.headlineLarge)

        SingleSetting(stringResource(Res.string.settings_theme_dark)) {
            Switch(settings.isDark, onCheckedChange = { onUpdate(settings.copy(isDark = !settings.isDark)) })
        }

        SingleSetting(stringResource(Res.string.settings_theme_color)) {
            Text("TODO color picker wheel")
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
