package api.plugin

import model.MidiNode
import dev.stashy.midifunk.events.MidiEvent
import kotlinx.coroutines.channels.ProducerScope
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("test-node")
class TestNode : MidiNode {
    var value1 = "default"
    var value2 = "default"

    override suspend fun ProducerScope<MidiEvent>.process(input: ReceiveChannel<MidiEvent>) {
        for (event in input) {
            send(event)
        }
    }
}