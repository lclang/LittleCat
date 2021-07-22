package lclang

open class Value(
    val type: () -> Type,
    val get: () -> Any?,
    val set: (Value?) -> Unit = { throw Exception("not settable value") },
    var isReturn: Boolean = false,
    var stop: Boolean = false
){
    constructor(type: Type, value: Any?): this({ type }, { value })
}