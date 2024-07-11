package model

import kotlinx.serialization.Serializable
import model.nodes.Node

@Serializable
data class Graph(
    val id: String,
    val name: String,
    val inputs: List<String>,
    val nodes: List<Node>,
    val disabled: Boolean = false
)
