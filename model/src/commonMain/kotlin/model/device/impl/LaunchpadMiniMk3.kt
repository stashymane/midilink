package model.device.impl

import dev.stashy.midifunk.device.MidiDevice
import dev.stashy.midifunk.device.MidiPort
import model.device.LightingSupport

class LaunchpadMiniMk3 : MidiDevice, LightingSupport { //ModeSupport
    override fun staticLight(note: UInt, color: UInt) {
        TODO("Not yet implemented")
    }

    override val description: String
        get() = TODO("Not yet implemented")
    override val id: String
        get() = TODO("Not yet implemented")
    override val input: MidiPort.Input
        get() = TODO("Not yet implemented")
    override val name: String
        get() = TODO("Not yet implemented")
    override val output: MidiPort.Output
        get() = TODO("Not yet implemented")
    override val vendor: String
        get() = TODO("Not yet implemented")
    override val version: String
        get() = TODO("Not yet implemented")

    override fun close() {
        TODO("Not yet implemented")
    }
}