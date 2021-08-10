package lclang

import lclang.methods.LibraryMethod
import lclang.methods.Method
import lclang.types.Type
import lclang.types.Types

class ValueList(file: LCFileVisitor): LCClass("array", file) {
    val list = ArrayList<Value>()

    fun add(value: Value) = list.add(value)
    fun get(index: Int) = list[index]
    fun last() = list.last()

    init{
        variables["join"] = object: LibraryMethod(listOf(Types.STRING), Types.ARRAY) {
            override fun callMethod(fileVisitor: LCFileVisitor, args: List<Any?>): Any {
                return join(args[0].toString())
            }
        }
    }

    fun join(spectator: String): String{
        var str = ""
        for((i, el) in list.withIndex()){
            str += "${el.get()}" + if(list.size != i+1) spectator else ""
        }

        return str
    }

    override fun toString(): String {
        return "[${join(", ")}]"
    }

    operator fun plus(a: ValueList): ValueList {
        for(el in a.list) list.add(el)
        return this
    }
}