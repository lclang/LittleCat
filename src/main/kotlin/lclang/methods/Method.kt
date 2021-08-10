package lclang.methods

import lclang.LCFileVisitor
import lclang.Value
import lclang.types.BaseType
import lclang.types.CallableType

abstract class Method(val args: List<BaseType>,
                      val returnType: BaseType
): Value(CallableType(args, returnType), null){
    abstract fun call(fileVisitor: LCFileVisitor, args: List<Value>): Any?

    override fun toString(): String = type().toString()
}