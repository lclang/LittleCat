package lclang.libs.lang

import lclang.constructor
import lclang.methods.Method
import lclang.types.Types

class IntClass: NumberClass {
    override var constructor: Method? = constructor(listOf(Types.ANY)) { list ->
        IntClass(list[0].toString().toInt())
    }

    var int: Int = 0
    constructor(): super("int")
    constructor(int: Int): super("int", int) {
        this.int = int

    }

    override fun equals(other: Any?): Boolean {
        if(other is IntClass)
            return other.int == int

        return false
    }

    override fun toString(): String = int.toString()
    override fun hashCode(): Int = int.hashCode()
}