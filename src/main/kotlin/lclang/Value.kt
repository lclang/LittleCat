package lclang

class Value(
    val type: () -> Type,
    val get: () -> Any?,
    val set: (Value?) -> Unit = { throw Exception("not settable value") }
){
    constructor(type: Type, value: Any?): this({ type }, { value })
}