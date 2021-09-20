package lclang

import lclang.exceptions.LCLangException
import lclang.types.BaseType

open class Value(
    val type: () -> BaseType,
    var get: () -> Any?,
    var set: (LCFileVisitor, Int, Int, Value) -> Unit = { fileVisitor, start, column, _ ->
        throw LCLangException("Invalid operation", "Value is not settable", start, column, fileVisitor.path) },
    var isReturn: Boolean = false,
    var stop: Boolean = false
){
    constructor(type: BaseType, value: Any?): this({ type }, { value })
}