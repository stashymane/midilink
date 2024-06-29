package api

interface Plugin {
    val id: String
    val version: String

    fun ModuleScope.load()
}
