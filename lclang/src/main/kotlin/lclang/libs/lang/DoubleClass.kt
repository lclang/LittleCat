package lclang.libs.lang

import lclang.constructor
import lclang.methods.Method
import lclang.types.Types

class DoubleClass: NumberClass {
    override var constructor: Method? = constructor(listOf(Types.ANY)) { list ->
        DoubleClass(list[0].toString().toDouble())
    }

    var double: Double = 0.0
    constructor(): super("double")
    constructor(double: Double): super("double", double) {
        this.double = double

    }

    override fun equals(other: Any?): Boolean {
        if(other is DoubleClass)
            return other.double == double

        return false
    }

    override fun toString(): String = double.toString()
    override fun hashCode(): Int = double.hashCode()
}