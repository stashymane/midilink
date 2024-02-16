package dev.stashy.midilink.module.midi

import androidx.compose.runtime.Composable
import dev.stashy.midilink.flow.FlowNode
import dev.stashy.midilink.flow.LinkModule

class MidiModule: LinkModule() {
    override val nodes: List<FlowNode>
        get() = TODO("Not yet implemented")

    @Composable
    override fun getSettingsView(node: FlowNode) {
        TODO("Not yet implemented")
    }
}
