package components

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import model.device.DeviceMeta
import theme.PreviewContainer
import theme.border

@Composable
fun DeviceCard(name: String, type: DeviceMeta.Type, onClick: () -> Unit = {}) {
    val icon = when (type) {
        DeviceMeta.Type.GRID -> Icons.Default.GridView
        DeviceMeta.Type.KEYBOARD -> Icons.Default.Piano
        DeviceMeta.Type.MIXER -> Icons.Default.Tune
        DeviceMeta.Type.GENERIC -> Icons.Default.Usb
        DeviceMeta.Type.SYSTEM -> Icons.Default.Computer
    }

    TextButton(
        onClick = onClick,
        border = BorderStroke(2.dp, MaterialTheme.colorScheme.border),
        contentPadding = PaddingValues(8.dp, 0.dp)
    ) {
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp), modifier = Modifier.padding(8.dp)) {
            Icon(icon, null)
            Text(name)
        }
    }
}

@Preview
@Composable
private fun DeviceCardPreview() {
    PreviewContainer {
        DeviceCard("Grid device", DeviceMeta.Type.GRID) {}
        DeviceCard("Keyboard device", DeviceMeta.Type.KEYBOARD) {}
        DeviceCard("Mixer device", DeviceMeta.Type.MIXER) {}
        DeviceCard("Generic device", DeviceMeta.Type.GENERIC) {}
    }
}