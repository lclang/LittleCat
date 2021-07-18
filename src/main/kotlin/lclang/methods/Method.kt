package lclang.methods

import lclang.Type
import lclang.Value

abstract class Method(val args: List<Type>,
                      val returnType: Type) {
    abstract fun call(args: List<Value?>): Any?
}