package model.device

import dev.stashy.midifunk.device.MidiDevice

class MidilinkDevice(device: MidiDevice, val meta: DeviceMeta = DeviceMeta()) : MidiDevice by device
