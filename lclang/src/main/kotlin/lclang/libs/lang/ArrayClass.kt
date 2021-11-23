package lclang.libs.lang

import lclang.LCClass
import lclang.method
import lclang.methods.Method
import lclang.types.CallableType
import lclang.types.Types
import lclang.void

class ArrayClass() : LCClass("array") {
    lateinit var list: MutableList<LCClass>

    fun add(clazz: LCClass) = list.add(clazz)
    operator fun get(index: Int) = list.getOrNull(index) ?: NullClass.NULL
    constructor(l: List<LCClass>): this() {
        list = l.toMutableList()
        globals["filter"] = method(listOf(CallableType(arrayOf(Types.ANY), Types.BOOL)), Types.ARRAY) {
            val filter = it[0] as Method
            ArrayClass(list.filter { value ->
                filter.call(this, listOf(value.asValue())) == BoolClass.TRUE
            })
        }

        globals["forEach"] = void(CallableType(arrayOf(Types.ANY))) {
            val forEach = it[0] as Method
            list.forEach { value -> forEach.call(this, listOf(value.asValue())) }
        }

        globals["join"] = method(listOf(Types.STRING), Types.ARRAY) {
            StringClass(join(it[0].toString()))
        }

        globals["add"] = void(Types.ANY) {
            add(it[0])
        }

        globals["size"] = void { IntClass(list.size) }
    }

    fun join(spectator: String) = list.joinToString(spectator) { it.toString() }
    override fun toString(): String = "[${join(", ")}]"

    operator fun plus(a: ArrayClass): ArrayClass {
        val list = ArrayClass(this.list)
        list.list.addAll(a.list)
        return list
    }
}