package lclang.lang

import lclang.LCClass
import lclang.Value
import lclang.constructor
import lclang.method
import lclang.methods.Method
import lclang.types.Types

class StringClass(): LCClass("string") {
    override var constructor: Method = constructor(listOf(Types.ANY), returnType = Types.STRING) { list ->
        StringClass(list[0].toString())
    }

    lateinit var string: String

    constructor(string: String): this() {
        this.string = string

        globals["length"] = Value(Types.INT, string.length)
        globals["charAt"] = method(listOf(Types.INT), Types.STRING) { string[it[0] as Int].toString() }
        globals["toArray"] = method(listOf(), Types.ARRAY) {
            ArrayClass().apply {
                for (c in string) add(Value(Types.CHAR, c))
            }
        }

        globals["toArray"] = method(listOf(Types.CHAR), Types.ARRAY) { args ->
            val parts = string.split(args[0] as Char)
            ArrayClass().apply {
                for(part in parts){
                    add(Value(Types.STRING, part))
                }
            }
        }

        globals["substring"] = method(listOf(Types.INT, Types.INT), Types.ARRAY) {
            string.substring(it[0] as Int, it[1] as Int)
        }

        globals["substring"] = method(listOf(Types.INT, Types.INT), Types.ARRAY) {
            string.substring(it[0] as Int, it[1] as Int)
        }

        globals["find"] = method(listOf(Types.CHAR), Types.INT) { args ->
            val needChar = (args[0] as CharClass).char
            string.indexOf(needChar)
        }
    }

    override fun equals(other: Any?): Boolean {
        if(other is StringClass)
            return other.string == string

        return false
    }

    override fun toString(): String = string
        .replace("\\n", "\n")
        .replace("\\r", "\r")
        .replace("\\b", "\b")
        .replace("\\t", "\t")
    override fun hashCode(): Int = string.hashCode()
}