package dev.stashy.midilink.module.midi.nodes

import dev.stashy.midifunk.device.MidiDevice
import dev.stashy.midifunk.events.MidiData
import dev.stashy.midilink.flow.output.FlowOutput
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.SendChannel

class MidiOutput(private val device: MidiDevice) : FlowOutput<MidiData> {
    override fun open(scope: CoroutineScope): SendChannel<MidiData> =
        device.output.open(scope)

    override val name: String = "MIDI Output"
    override val description: String = "Outputs events to a MIDI device."
    override val subtitle: String = device.name
}
