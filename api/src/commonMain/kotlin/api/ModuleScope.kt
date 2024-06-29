package api

import androidx.compose.runtime.Composable
import kotlinx.serialization.modules.SerializersModule
import model.MidiNode

interface ModuleScope {
    fun <T : MidiNode> registerNode(module: SerializersModule, init: () -> T, ui: @Composable NodeScope<T>.() -> Unit)
}