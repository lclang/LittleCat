package lclang.libs.lang

import lclang.LCClass
import lclang.constructor
import lclang.method
import lclang.methods.Method
import lclang.types.Types

class CharClass(): LCClass("char") {
    var char: Char = '!'

    override var constructor: Method? = constructor { list ->
        CharClass(list[0].toString().toCharArray().first())
    }

    constructor(char: Char): this() {
        this.char = char

        globals["getValue"] = IntClass(char.code).asValue()
        globals["upper"] = method(listOf(), Types.CHAR) {
            CharClass(char.uppercaseChar())
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