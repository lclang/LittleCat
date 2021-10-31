package lclang.libs.lang

import lclang.*
import lclang.methods.Method
import lclang.types.CallableType
import lclang.types.Types

class ArrayClass() : LCClass("array") {
    lateinit var list: MutableList<Value>

    fun add(value: Value) = list.add(value)
    operator fun get(index: Int) = list.getOrNull(index) ?: Value(Types.UNDEFINED, null)

    constructor(l: List<Value>): this() {
        list = l.toMutableList()
        globals["filter"] = method(listOf(CallableType(arrayOf(Types.ANY), Types.BOOL)), Types.ARRAY) {
            val filter = it[0] as Method
            ArrayClass(list.filter { value ->
                filter.call(this, listOf(value)) == BoolClass.TRUE
            })
        }

        globals["forEach"] = void(CallableType(arrayOf(Types.ANY))) {
            val forEach = it[0] as Method
            list.forEach { value -> forEach.call(this, listOf(value)) }
        }

        globals["join"] = method(listOf(Types.STRING), Types.ARRAY) {
            StringClass(join(this, it[0].toString()))
        }

        globals["add"] = void(Types.ANY) {
            add(it[0]!!.asValue())
        }

        globals["size"] = void { IntClass(list.size) }
    }

    fun join(caller: Caller, spectator: String) = list.joinToString(spectator) { it.get(caller).toString() }
    override fun toString(): String = "[${join(Caller(this, 0, 0), ", ")}]"

    operator fun plus(a: ArrayClass): ArrayClass {
        val list = ArrayClass(this.list)
        list.list.addAll(a.list)
        return list
    }
}