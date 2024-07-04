package model.device

import kotlinx.serialization.json.Json

actual fun fetchAliases(): Map<String, String> =
    loadResource("device-aliases.json")?.let(Json.Default::decodeFromString) ?: mapOf()

actual fun fetchMeta(deviceId: String): DeviceMeta? =
    loadResource("devices/$deviceId.json")?.let { Json.Default.decodeFromString<DeviceMeta>(it) }

private fun loadResource(path: String): String? =
    DeviceManager::class.java.getResourceAsStream(path)?.readAllBytes()?.decodeToString()
