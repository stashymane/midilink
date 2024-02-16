package dev.stashy.midilink.flow.output

import dev.stashy.midilink.flow.FlowNode
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.SendChannel

interface FlowOutput<T> : FlowNode {
    fun open(scope: CoroutineScope): SendChannel<T>
}
