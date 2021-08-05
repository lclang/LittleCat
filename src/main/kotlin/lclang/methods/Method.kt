package lclang.methods

import lclang.LCFileVisitor
import lclang.types.Type
import lclang.Value
import lclang.types.BaseType

abstract class Method(val args: List<BaseType>,
                      val returnType: BaseType
): Value(Type.CALLABLE, null){

    abstract fun call(fileVisitor: LCFileVisitor, args: List<Any?>): Any?
}