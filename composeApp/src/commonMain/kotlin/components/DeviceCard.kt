package components

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.GridView
import androidx.compose.material.icons.filled.Piano
import androidx.compose.material.icons.filled.Tune
import androidx.compose.material.icons.filled.Usb
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import model.device.DeviceType
import theme.PreviewContainer
import theme.border

@Composable
fun DeviceCard(name: String, type: DeviceType, onClick: () -> Unit = {}) {
    val icon = when (type) {
        DeviceType.GRID -> Icons.Default.GridView
        DeviceType.KEYBOARD -> Icons.Default.Piano
        DeviceType.MIXER -> Icons.Default.Tune
        DeviceType.GENERIC -> Icons.Default.Usb
    }

    TextButton(
        onClick = onClick,
        border = BorderStroke(2.dp, MaterialTheme.colorScheme.border),
        contentPadding = PaddingValues(8.dp, 0.dp),
        enabled = false
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
        DeviceCard("Grid device", DeviceType.GRID) {}
        DeviceCard("Keyboard device", DeviceType.KEYBOARD) {}
        DeviceCard("Mixer device", DeviceType.MIXER) {}
        DeviceCard("Generic device", DeviceType.GENERIC) {}
    }
}