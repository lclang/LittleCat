package lclang.libs.lang

import lclang.Caller
import lclang.constructor
import lclang.types.Types

class DoubleClass: NumberClass {
    var double: Double = 0.0
    constructor(): super("double")
    constructor(double: Double): super("double", double) {
        this.double = double

    }

    init {
        constructor = constructor(listOf(Types.ANY)) { list ->
            DoubleClass(list[0].toString(this).toDouble())
        }
    }

    override fun equals(other: Any?): Boolean {
        if(other is DoubleClass)
            return other.double == double

        return false
    }

    override fun toString(caller: Caller): String = double.toString()
    override fun hashCode(): Int = double.hashCode()
}