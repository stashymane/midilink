package model.nodes

import dev.stashy.midifunk.device.MidiDevice
import dev.stashy.midifunk.events.MidiEvent
import kotlinx.coroutines.channels.ProducerScope
import kotlinx.coroutines.channels.ReceiveChannel

interface Node {
    suspend fun ProducerScope<Context>.process(input: ReceiveChannel<Context>)

    interface Context {
        val device: MidiDevice
        val event: MidiEvent
    }
}
