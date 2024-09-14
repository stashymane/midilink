package screens

import androidx.compose.runtime.Composable
import model.device.DeviceManager
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun DeviceScreen(deviceId: String) {
    val device = DeviceManager.list().find { it.id == deviceId }
}

@Preview
@Composable
private fun DeviceScreenPreview() {
    DeviceScreen("test")
}