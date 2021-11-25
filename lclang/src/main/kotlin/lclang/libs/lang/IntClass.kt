package lclang.libs.lang

import lclang.Caller
import lclang.constructor
import lclang.types.Types

class IntClass: NumberClass {
    var int: Int = 0
    private constructor(): super("int")
    private constructor(int: Int): super("int", int) {
        this.int = int
    }

    init {
        constructor = constructor(listOf(Types.ANY)) { list ->
            get(list[0].toString(this).toInt())
        }
    }

    override fun equals(other: Any?): Boolean {
        if(other is IntClass)
            return other.int == int

        return false
    }

    override fun toString(caller: Caller): String = int.toString()
    override fun hashCode(): Int = int.hashCode()

    companion object {
        val instance = IntClass()
        val integers = HashMap<Int, IntClass>()

        fun get(int: Int): IntClass {
            if(integers.containsKey(int))
                return integers[int]!!

            val intClazz = IntClass(int)
            integers[int] = intClazz
            return intClazz
        }
    }
}