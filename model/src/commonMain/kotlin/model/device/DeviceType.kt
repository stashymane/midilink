package model.device

import kotlinx.serialization.Serializable

@Serializable
enum class DeviceType {
    KEYBOARD,
    GRID,
    MIXER,
    GENERIC
}