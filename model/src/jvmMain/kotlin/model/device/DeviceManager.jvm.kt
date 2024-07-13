package model.device

import kotlinx.serialization.json.Json

actual fun getDatabase(): List<DeviceMeta> = meta

val meta: List<DeviceMeta> by lazy {
    devices.mapNotNull { loadResource("/devices/$it.json") }.map(Json.Default::decodeFromString)
}

private fun loadResource(path: String): String? =
    DeviceManager::class.java.getResource(path)?.readText()

private val devices =
    listOf(
        "gervill",
        "komplete-audio-6-mk2",
        "ms-midi-mapper",
        "ms-wavetable-synth",
        "real-time-sequencer"
    ) //this is actually awful and i want to get rid of this soon