package dev.stashy.midilink.flow.input

import dev.stashy.midilink.flow.FlowNode
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.ReceiveChannel

interface FlowInput<T>: FlowNode {
    fun open(scope: CoroutineScope): ReceiveChannel<T>
}
