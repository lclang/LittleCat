package lclang.libs.lang

import lclang.*
import lclang.types.Types

class StringClass(): LCClass("string") {
    lateinit var string: String

    constructor(string: String): this() {
        this.string = string

        globals["length"] = IntClass(string.length).asValue()
        globals["charAt"] = method(listOf(Types.INT), Types.CHAR) { CharClass(string[it[0].int().int]) }
        globals["toArray"] = method(listOf(), Types.ARRAY) {
            ArrayClass(string.map { CharClass(it) })
        }

        globals["split"] = method(listOf(Types.CHAR), Types.ARRAY) { args ->
            ArrayClass(string.split(args[0].char().char).map {
                StringClass(it)
            })
        }

        globals["substring"] = method(listOf(Types.INT, Types.INT), Types.ARRAY) {
            StringClass(string.substring(it[0].int().int, it[1].int().int))
        }

        globals["substring"] = method(listOf(Types.INT, Types.INT), Types.ARRAY) {
            StringClass(string.substring(it[0].int().int, it[1].int().int))
        }

        globals["find"] = method(listOf(Types.CHAR), Types.INT) { args ->
            IntClass(string.indexOf(args[0].char().char))
        }
    }

    init {
        constructor = constructor(listOf(Types.ANY)) { list ->
            StringClass(list[0].toString())
        }
    }

    override fun equals(other: Any?): Boolean {
        if(other is StringClass)
            return other.string == string

        return false
    }

    override fun toString(): String = string
    override fun hashCode(): Int = string.hashCode()
}