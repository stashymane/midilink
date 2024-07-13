package model.device

import dev.stashy.midifunk.device.MidiDevice

object DeviceManager {
    val mappings: Map<String, DeviceMeta> =
        getDatabase().flatMap { entry -> entry.names.map { name -> name to entry } }.toMap()

    fun list(): List<MidilinkDevice> = MidiDevice.list().map { device ->
        val meta = mappings[device.name] ?: DeviceMeta()
        MidilinkDevice(device, meta)
    }
}

expect fun getDatabase(): List<DeviceMeta>
