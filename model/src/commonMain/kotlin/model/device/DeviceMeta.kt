package model.device

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DeviceMeta(val type: DeviceType = DeviceType.GENERIC)

@Serializable
enum class DeviceType {
    @SerialName("keyboard")
    KEYBOARD,

    @SerialName("grid")
    GRID,

    @SerialName("mixer")
    MIXER,

    @SerialName("generic")
    GENERIC,

    @SerialName("system")
    SYSTEM
}