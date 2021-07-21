package lclang.lang

import lclang.LCClass
import lclang.LCContextVisitor
import lclang.LCFileVisitor
import lclang.Type
import lclang.methods.Method

class StringClass(val string: String, parent: LCFileVisitor): LCClass("string", parent) {
    init {
        methods["charAt"] = object: Method(listOf(Type.INT), Type.STRING) {
            override fun call(fileVisitor: LCFileVisitor, args: List<Any?>): Any {
                return string[args[0] as Int].toString()
            }
        }
    }

    override fun equals(other: Any?): Boolean {
        if(other is StringClass)
            return other.string == string

        return false
    }

    override fun toString(): String = string
    override fun hashCode(): Int = string.hashCode()
}