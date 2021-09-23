package lclang.lang

import lclang.*
import lclang.methods.Method
import lclang.types.CallableType
import lclang.types.Types

class ArrayClass(file: LCFileVisitor): LCClass("array", file) {
    val list = ArrayList<Value>()

    fun add(value: Value) = list.add(value)
    operator fun get(index: Int) = list[index]
    fun last() = list.last()

    init {
        globals["filter"] = method(listOf(CallableType(listOf(Types.ANY), Types.BOOL)), Types.ARRAY) {
            val filter = it[0] as Method
            list.filter { value ->
                filter.call(this, listOf(value)) == true
            }
        }

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