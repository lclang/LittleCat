package lclang.methods

import lclang.LCFileVisitor
import lclang.types.Type
import lclang.Value
import lclang.types.BaseType
import lclang.types.CallableType

abstract class Method(val args: List<BaseType>,
                      val returnType: BaseType
): Value(CallableType(args, returnType), null){
    abstract fun call(fileVisitor: LCFileVisitor, args: List<Any?>): Any?
}