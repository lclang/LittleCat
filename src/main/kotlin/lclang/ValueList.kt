package lclang

class ValueList(file: LCFileVisitor): LCClass("array", file) {
    val list = ArrayList<Value>()

    fun add(value: Value) = list.add(value)
    fun get(index: Int) = list[index]
    fun last() = list.last()

    override fun toString(): String {
        var str = ""
        for((i, el) in list.withIndex()){
            str += el.get().toString() + if(list.size != i+1) ", " else ""
        }

        return "[$str]"
    }

    operator fun plus(a: ValueList): ValueList {
        for(el in a.list) list.add(el)
        return this
    }
}