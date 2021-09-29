package lclang.lang

import lclang.LCClass
import lclang.Value
import lclang.constructor
import lclang.method
import lclang.methods.Method
import lclang.types.Types

class CharClass(): LCClass("char") {
    var char: Char = '!'

    override var constructor: Method = constructor(returnType = Types.CHAR) { list ->
        CharClass(list[0].toString().toCharArray().first())
    }

    constructor(char: Char): this() {
        this.char = char

        globals["getValue"] = Value(Types.INT) { char.code }
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