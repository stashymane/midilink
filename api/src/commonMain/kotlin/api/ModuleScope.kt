package api

import androidx.compose.runtime.Composable
import kotlinx.serialization.modules.SerializersModule
import model.nodes.Node

interface ModuleScope {
    fun <T : Node> registerNode(module: SerializersModule, init: () -> T, ui: @Composable NodeScope<T>.() -> Unit)
}
