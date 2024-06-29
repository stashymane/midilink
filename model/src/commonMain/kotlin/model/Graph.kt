package model

import kotlinx.serialization.Serializable

@Serializable
data class Graph(
    val id: String,
    val name: String,
    val inputs: List<String>,
    val nodes: List<MidiNode>,
    val disabled: Boolean = false
)
