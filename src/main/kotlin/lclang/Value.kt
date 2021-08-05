package lclang

import lclang.types.BaseType

open class Value(
    val type: () -> BaseType,
    var get: () -> Any?,
    var set: (Value?) -> Unit = { throw Exception("not settable value") },
    var isReturn: Boolean = false,
    var stop: Boolean = false
){
    constructor(type: BaseType, value: Any?): this({ type }, { value })
}