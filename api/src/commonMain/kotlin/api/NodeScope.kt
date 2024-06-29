package api

interface NodeScope<T> {
    fun update(node: T)
}