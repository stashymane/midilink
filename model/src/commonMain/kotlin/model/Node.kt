package model

import dev.stashy.midifunk.events.MidiEvent
import kotlinx.coroutines.channels.ProducerScope
import kotlinx.coroutines.channels.ReceiveChannel

interface Node<I, O> {
    suspend fun ProducerScope<MidiEvent>.process(input: ReceiveChannel<I>)
}

interface MidiNode : Node<MidiEvent, MidiEvent>
