package api.plugin

import api.ModuleScope
import api.Plugin
import kotlinx.serialization.modules.SerializersModule
import model.nodes.Node

class TestPlugin : Plugin {
    override val id: String = "test"
    override val version: String = "1.0.0"

    override fun ModuleScope.load() {
        registerNode(
            SerializersModule { polymorphic(Node::class, TestNode::class, TestNode.serializer()) },
            ::TestNode
        ) {

        }
    }
}