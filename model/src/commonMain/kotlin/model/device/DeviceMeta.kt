package model.device

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DeviceMeta(val names: List<String> = listOf(), val type: Type = Type.GENERIC) {
    @Serializable
    enum class Type {
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
}