package dev.stashy.midilink.module.midi.nodes

import dev.stashy.midifunk.device.MidiDevice
import dev.stashy.midifunk.events.MidiData
import dev.stashy.midilink.flow.input.FlowInput
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.ReceiveChannel

class MidiInput(private val device: MidiDevice) : FlowInput<MidiData> {
    override fun open(scope: CoroutineScope): ReceiveChannel<MidiData> =
        device.input.open(scope)

    override val name: String = "MIDI Input"
    override val description: String = "Receives input from MIDI devices."
    override val subtitle: String = device.name
}
