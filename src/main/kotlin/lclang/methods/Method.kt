package lclang.methods

import lclang.LCFileVisitor
import lclang.Type

abstract class Method(val args: List<Type>,
                      val returnType: Type) {
    abstract fun call(fileVisitor: LCFileVisitor, args: List<Any?>): Any?
}