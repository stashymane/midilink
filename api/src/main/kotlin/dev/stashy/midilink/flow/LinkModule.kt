package dev.stashy.midilink.flow

import androidx.compose.runtime.Composable

abstract class LinkModule {
    abstract val nodes: List<FlowNode>

    @Composable
    abstract fun getSettingsView(node: FlowNode)
}
