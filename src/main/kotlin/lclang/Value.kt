package lclang

import lclang.exceptions.LCLangException
import lclang.types.Type

open class Value(
    val type: Type,
    var get: (Caller) -> Any?,
    var set: (Caller, Value) -> Unit = { caller, _ ->
        throw LCLangException("Invalid operation", "Value is not settable", caller) },
    var isReturn: Boolean = false,
    var stop: Boolean = false
){
    constructor(type: Type, value: Any?): this(type, { value })
}