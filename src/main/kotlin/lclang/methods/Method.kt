package lclang.methods

import lclang.LCFileVisitor
import lclang.Type
import lclang.Value

abstract class Method(val args: List<Type>,
                      val returnType: Type): Value(Type.CALLABLE, null){

    abstract fun call(fileVisitor: LCFileVisitor, args: List<Any?>): Any?
}