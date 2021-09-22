package lclang.lang

import lclang.LCClass
import lclang.LCFileVisitor
import lclang.method
import lclang.methods.Method
import lclang.types.Types

class CharClass(fileVisitor: LCFileVisitor): LCClass("char", fileVisitor) {
    var char: Char = '!'

    override val constructor: Method = method(returnType = Types.CHAR) { list ->
        CharClass(list[0].toString().toCharArray().first(), file)
    }

    constructor(char: Char, fileVisitor: LCFileVisitor) : this(fileVisitor) {
        this.char = char

        globals["getValue"] = method(returnType = Types.INT) { char.code }
        globals["upper"] = method(listOf(), Types.CHAR) { char.uppercase() }
    }

    override fun equals(other: Any?): Boolean {
        if(other is CharClass)
            return other.char == char

        return false
    }

    override fun toString(): String = char.toString()
    override fun hashCode(): Int = char.hashCode()
}