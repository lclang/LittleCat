package lclang

class Value(
    val type: () -> Type,
    val get: () -> Any?,
    val set: (Any?) -> Unit = { throw Exception("not settable value") }
)