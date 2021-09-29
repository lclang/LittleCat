package lclang.methods

import lclang.Caller
import lclang.LCRootExecutor
import lclang.Value
import lclang.types.CallableType
import lclang.types.Type

abstract class Method(
    val root: LCRootExecutor,
    val args: List<Type>,
    val returnType: Type
) {
    private val type = CallableType(args, returnType)

    abstract fun call(caller: Caller, args: List<Value>): Any?
    override fun toString() = type.toString()

    fun asValue() = Value(type, this)
}