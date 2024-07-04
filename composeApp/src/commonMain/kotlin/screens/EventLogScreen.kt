package screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import components.DropdownSwitch
import dev.stashy.midifunk.device.MidiDevice
import midilink.composeapp.generated.resources.Res
import midilink.composeapp.generated.resources.tab_event_log
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import theme.PreviewContainer

@Composable
fun EventLogScreen() {
    var currentDevice by remember { mutableStateOf<MidiDevice?>(null) }

    Column(Modifier.fillMaxSize().padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Text(stringResource(Res.string.tab_event_log), style = MaterialTheme.typography.headlineLarge)

        DropdownSwitch(MidiDevice.list(), currentDevice, { currentDevice = it }) {
            Text(it.name)
        }
    }
}

@Preview
@Composable
private fun EventLogScreenPreview() {
    PreviewContainer {
        EventLogScreen()
    }
}
