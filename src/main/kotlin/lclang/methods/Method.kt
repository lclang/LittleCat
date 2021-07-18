package lclang.methods

import lclang.Type

abstract class Method(val args: List<Type>,
                      val returnType: Type) {
    abstract fun call(args: List<Any?>): Any?
}