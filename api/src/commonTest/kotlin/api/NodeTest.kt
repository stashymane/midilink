package api

import androidx.compose.runtime.Composable
import api.plugin.TestNode
import api.plugin.TestPlugin
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic
import kotlinx.serialization.modules.subclass
import model.nodes.Node
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertIs

class NodeTest {
    @Test
    fun testNodeSerialization() {
        val module = SerializersModule {
            polymorphic(Node::class) {
                subclass(TestNode::class)
            }
        }
        val json = Json {
            serializersModule = module
            encodeDefaults = true
        }

        val updatedValue1 = "foo"
        val updatedValue2 = "bar"

        val node: Node = TestNode().apply {
            value1 = updatedValue1
            value2 = updatedValue2
        }

        val serialized = json.encodeToString(node)
        val deserialized = json.decodeFromString<Node>(serialized)

        assertIs<Node>(deserialized)
        assertIs<TestNode>(deserialized)
        assertEquals(updatedValue1, deserialized.value1)
        assertEquals(updatedValue2, deserialized.value2)
    }

    @Test
    fun testPluginLoading() {
        val plugins: List<Plugin> = listOf(TestPlugin())
        val serializers = mutableListOf<SerializersModule>()
        val initializers = mutableListOf<() -> Node>()

        val scope = object : ModuleScope {
            override fun <T : Node> registerNode(
                module: SerializersModule,
                init: () -> T,
                ui: @Composable() (NodeScope<T>.() -> Unit)
            ) {
                serializers += module
                initializers += init
            }
        }

        plugins.forEach { plugin ->
            plugin.apply {
                scope.load()
            }
        }

        val module = SerializersModule {
            serializers.forEach(::include)
        }
        val json = Json {
            serializersModule = module
            encodeDefaults = true
        }
        val nodes = initializers.map { it.invoke() }.toList()

        val encoded = json.encodeToString(nodes)
        println(encoded)
        json.decodeFromString<List<Node>>(encoded)

    }
}