package dev.stashy.midilink.flow.processor

import kotlinx.coroutines.channels.ReceiveChannel

interface FlowProcessor<T, R> {
    suspend fun process(channel: ReceiveChannel<T>): ReceiveChannel<R>
}
