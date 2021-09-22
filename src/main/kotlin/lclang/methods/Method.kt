package lclang.methods

import lclang.Caller
import lclang.Value
import lclang.types.CallableType
import lclang.types.Type

abstract class Method(val args: List<Type>,
                      val returnType: Type
): Value(CallableType(args, returnType), null) {
    abstract fun call(caller: Caller, args: List<Value>): Any?
    override fun toString() = type.toString()
}