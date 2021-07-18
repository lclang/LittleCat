package lclang

class Value(
    val get: () -> Any?,
    val set: (Any?) -> Unit = { throw Exception("not settable value") }
)