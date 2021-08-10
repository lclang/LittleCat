package lclang.lang

import lclang.LCClass
import lclang.LCFileVisitor
import lclang.methods.LibraryMethod
import lclang.types.Types
import lclang.methods.Method

class CharClass(val char: Char, fileVisitor: LCFileVisitor): LCClass("char", fileVisitor) {
    init {
        globals["getValue"] = object: LibraryMethod(listOf(), Types.INT) {
            override fun callMethod(fileVisitor: LCFileVisitor, args: List<Any?>): Any {
                return char.code
            }
        }

        globals["upper"] = object: LibraryMethod(listOf(), Types.CHAR) {
            override fun callMethod(fileVisitor: LCFileVisitor, args: List<Any?>): Any {
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