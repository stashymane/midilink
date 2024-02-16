package dev.stashy.midilink.ui.screens

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Save
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.stashy.midilink.flow.node.FlowNode
import dev.stashy.midilink.model.DeviceFlow
import dev.stashy.midilink.ui.theme.AppTheme

@Composable
fun FlowEditor(flow: DeviceFlow, onUpdate: (DeviceFlow) -> Unit) {
    var currentNode: FlowNode? by remember { mutableStateOf(null) }
    var editing: Boolean by remember { mutableStateOf(false) }

    Column(Modifier.padding(16.dp).fillMaxSize(), verticalArrangement = Arrangement.spacedBy(8.dp)) {
        AnimatedContent(editing, transitionSpec = { fadeIn() togetherWith fadeOut() }) {
            when (it) {
                true -> Row(
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    var currentName: String by remember { mutableStateOf(flow.name) }

                    TextField(currentName, { currentName = it })
                    IconButton({
                        onUpdate(flow.copy(name = currentName))
                        editing = false
                    }) {
                        Icon(Icons.Default.Save, null)
                    }
                }


                false -> Row(
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(flow.name, style = MaterialTheme.typography.headlineMedium)
                    IconButton({ editing = true }) {
                        Icon(Icons.Default.Edit, null)
                    }
                }
            }


        }

        Row {
            Column(Modifier.weight(3f)) {

            }
            AnimatedContent(currentNode, Modifier.weight(1f)) { node ->
                when (node) {
                    null -> Column {
                        Text("Select a node to start editing it.")
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
        FlowEditor(DeviceFlow("Test")) {}
    }
}
