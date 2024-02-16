package dev.stashy.midilink.flow

import dev.stashy.midifunk.events.MidiData
import dev.stashy.midilink.flow.input.FlowInput
import dev.stashy.midilink.flow.output.FlowOutput
import dev.stashy.midilink.flow.processor.FlowProcessor
import kotlinx.serialization.Serializable

@Serializable
data class DeviceFlow(
    val name: String,
    val inputs: List<FlowInput<MidiData>> = listOf(),
    val processors: List<FlowProcessor<MidiData, MidiData>> = listOf(),
    val outputs: List<FlowOutput<MidiData>> = listOf()
)
