package lclang.lang

import lclang.*
import lclang.types.Types

class ArrayClass(file: LCFileVisitor): LCClass("array", file) {
    val list = ArrayList<Value>()

    fun add(value: Value) = list.add(value)
    operator fun get(index: Int) = list[index]
    fun last() = list.last()

    init {
        globals["join"] = method(listOf(Types.STRING), Types.ARRAY) { join(this, it[0].toString()) }
        globals["size"] = Value(Types.INT) { list.size }
    }

    fun join(caller: Caller, spectator: String) = list.joinToString(spectator) { it.get(caller).toString() }
    override fun toString(): String = "[${join(Caller(fileVisitor, 0, 0), ", ")}]"

    operator fun plus(a: ArrayClass): ArrayClass {
        list.addAll(a.list)
        return this
    }
}