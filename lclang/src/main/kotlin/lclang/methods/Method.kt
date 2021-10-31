package lclang.methods

import lclang.Caller
import lclang.LCClass
import lclang.LCRootExecutor
import lclang.Value
import lclang.types.CallableType
import lclang.types.Type

abstract class Method(
    val root: LCRootExecutor,
    val args: Array<out Type>,
    val returnType: Type
): LCClass("method") {
    private val type: Type = CallableType(args, returnType)

    abstract fun call(caller: Caller, args: List<Value>): LCClass?
    override fun toString() = type.toString()
    override fun asValue() = Value(type, this)
}