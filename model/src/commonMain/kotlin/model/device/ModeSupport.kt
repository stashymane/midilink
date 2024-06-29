package model.device

import dev.stashy.midifunk.device.MidiDevice

interface ModeSupport<T> : MidiDevice {
    val currentMode: T
    fun mode(mode: T)
}