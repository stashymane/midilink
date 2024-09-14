package model

import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

object IntRangeAsStringSerializer : KSerializer<IntRange> {
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("IntRange", PrimitiveKind.STRING)

    override fun deserialize(decoder: Decoder): IntRange {
        val values = decoder.decodeString().split('-').map { it.toInt() }

        return IntRange(values[0], values[1])
    }

    override fun serialize(encoder: Encoder, value: IntRange) {
        encoder.encodeString("${value.first}-${value.last}")
    }
}