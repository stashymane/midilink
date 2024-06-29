package model.device

import dev.stashy.midifunk.device.MidiDevice

interface LightingSupport : MidiDevice {
    fun staticLight(note: UInt, color: UInt)
}
