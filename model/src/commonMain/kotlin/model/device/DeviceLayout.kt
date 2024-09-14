package model.device

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import model.IntRangeAsStringSerializer

@Serializable
sealed class Element {
    abstract val size: Int

    @Serializable
    @SerialName("keyboard")
    data class Keyboard(
        val noteRange: @Serializable(with = IntRangeAsStringSerializer::class) IntRange,
        override val size: Int = 1
    ) : Element()

    @Serializable
    @SerialName("pad")
    data class Pad(val note: Int, override val size: Int = 1) : Element()

    @Serializable
    @SerialName("knob")
    data class Knob(val note: Int, override val size: Int = 1) : Element()

    @Serializable
    @SerialName("fader")
    data class Fader(val note: Int, override val size: Int = 1) : Element()

    @Serializable
    @SerialName("spacer")
    data class Spacer(override val size: Int = 1) : Element()
}

@Serializable
sealed class Container : Element() {
    @Serializable
    @SerialName("row")
    data class Row(val elements: List<Element>, override val size: Int = elements.sumOf { it.size }) : Container()

    @Serializable
    @SerialName("column")
    data class Column(val elements: List<Element>, override val size: Int = elements.sumOf { it.size }) : Container()
}