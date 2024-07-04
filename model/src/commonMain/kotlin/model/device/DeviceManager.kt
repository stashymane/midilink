package model.device

import dev.stashy.midifunk.device.MidiDevice

object DeviceManager {
    private val aliases = fetchAliases()
    private val metaCache: MutableMap<String, DeviceMeta> = mutableMapOf()

    fun list(): List<MidilinkDevice> = MidiDevice.list().map { device ->
        val meta = aliases[device.name]?.let { getMeta(it) } ?: DeviceMeta()
        MidilinkDevice(device, meta)
    }

    private fun getMeta(id: String) =
        metaCache.getOrPut(id) { fetchMeta(id) ?: DeviceMeta() }
}

expect fun fetchAliases(): Map<String, String>
expect fun fetchMeta(deviceId: String): DeviceMeta?
