package api.plugin

import kotlinx.coroutines.channels.ProducerScope
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import model.nodes.Node
import model.nodes.Node.Context

@Serializable
@SerialName("test-node")
class TestNode : Node {
    var value1 = "default"
    var value2 = "default"

    override suspend fun ProducerScope<Context>.process(input: ReceiveChannel<Context>) {
        for (event in input) {
            send(event)
        }
    }
}