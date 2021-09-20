package lclang

import lclang.methods.LibraryMethod
import lclang.types.Types

class ValueList(file: LCFileVisitor): LCClass("array", file) {
    val list = ArrayList<Value>()

    fun add(value: Value) = list.add(value)
    fun get(index: Int) = list[index]
    fun last() = list.last()

    init{
        globals["join"] = object: LibraryMethod(listOf(Types.STRING), Types.ARRAY) {
            override fun callMethod(fileVisitor: LCFileVisitor, args: List<Any?>): Any {
                return join(args[0].toString())
            }
        }

        globals["size"] = Value(Types.INT) { list.size }
    }

    fun join(spectator: String) = list.joinToString(spectator) { it.get().toString() }
    override fun toString(): String = "[${join(", ")}]"

    operator fun plus(a: ValueList): ValueList {
        list.addAll(a.list)
        return this
    }
}