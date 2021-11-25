package lclang.libs.lang

import lclang.Caller
import lclang.constructor
import lclang.types.Types

class LongClass: NumberClass {
    var long: Long = 0L
    constructor(): super("long")
    constructor(long: Long): super("long", long) {
        this.long = long
    }

    init {
        constructor = constructor(listOf(Types.ANY)) { list ->
            LongClass(list[0].toString(this).toLong())
        }
    }

    override fun equals(other: Any?): Boolean {
        if(other is LongClass)
            return other.long == long

        return false
    }

    override fun toString(caller: Caller): String = long.toString()
    override fun hashCode(): Int = long.hashCode()
}