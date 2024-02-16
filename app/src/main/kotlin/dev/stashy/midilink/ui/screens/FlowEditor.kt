package dev.stashy.midilink.ui.screens

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import dev.stashy.midifunk.device.MidiDevice
import dev.stashy.midilink.flow.DeviceFlow
import dev.stashy.midilink.ui.components.Item
import dev.stashy.midilink.ui.components.ItemDropdown
import dev.stashy.midilink.ui.theme.AppTheme

@Composable
fun FlowEditor(flow: DeviceFlow) {
    Column(Modifier.padding(16.dp).fillMaxSize(), verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Text(flow.name, fontSize = 1.6.em, fontWeight = FontWeight.Bold)

        Row {
            Column {
                ItemDropdown({ Text("Input devices") }) {
                    MidiDevice.list().filter { it.input.isPresent }.forEach {
                        Item({ Text(it.name) }, {})
                    }
                }
            }
            Column {
                ItemDropdown({ Text("Output devices") }) {
                    MidiDevice.list().filter { it.output.isPresent }.forEach {
                        Item({ Text(it.name) }, {})
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun FlowEditorPreview() {
    AppTheme {
        FlowEditor(DeviceFlow("Test"))
    }
}
