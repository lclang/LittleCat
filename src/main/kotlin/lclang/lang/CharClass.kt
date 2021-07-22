package lclang.lang

import lclang.LCClass
import lclang.LCFileVisitor
import lclang.Type
import lclang.methods.Method

class CharClass(val char: Char, parent: LCFileVisitor): LCClass("char", parent, char) {
    init {
        methods["getValue"] = object: Method(listOf(), Type.INT) {
            override fun call(fileVisitor: LCFileVisitor, args: List<Any?>): Any {
                return char.code
            }
        }
        methods["upper"] = object: Method(listOf(), Type.CHAR) {
            override fun call(fileVisitor: LCFileVisitor, args: List<Any?>): Any {
                return char.uppercase()
            }
        }
    }

    override fun equals(other: Any?): Boolean {
        if(other is CharClass)
            return other.char == char

        return false
    }

    override fun toString(): String = char.toString()
    override fun hashCode(): Int = char.hashCode()
}