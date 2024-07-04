package screens

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import components.DeviceCard
import midilink.composeapp.generated.resources.Res
import midilink.composeapp.generated.resources.devices_none_connected
import midilink.composeapp.generated.resources.section_devices
import model.device.DeviceType
import model.device.MidilinkDevice
import org.jetbrains.compose.resources.stringResource

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun HomeScreen(devices: List<MidilinkDevice>) {
    val midiDevicesEmpty = devices.isEmpty()

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(stringResource(Res.string.section_devices), style = MaterialTheme.typography.headlineLarge)
        FlowRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            if (midiDevicesEmpty)
                Text(stringResource(Res.string.devices_none_connected))
            else
                devices.filter { it.meta.type != DeviceType.SYSTEM }.forEach {
                    DeviceCard(it.name, DeviceType.GENERIC) {}
                }
        }
    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    HomeScreen(listOf())
}