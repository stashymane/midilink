package api.plugin

import api.ModuleScope
import api.Plugin
import kotlinx.serialization.modules.SerializersModule
import model.MidiNode

class TestPlugin : Plugin {
    override val id: String = "test"
    override val version: String = "1.0.0"

    override fun ModuleScope.load() {
        registerNode(
            SerializersModule { polymorphic(MidiNode::class, TestNode::class, TestNode.serializer()) },
            ::TestNode
        ) {

        }
    }
}