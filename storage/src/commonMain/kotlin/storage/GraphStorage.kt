package storage

import model.Graph

interface GraphStorage {
    suspend fun save(graph: Graph)
    suspend fun read(id: String)
}
