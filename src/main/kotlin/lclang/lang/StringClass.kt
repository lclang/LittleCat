package lclang.lang

import lclang.*
import lclang.methods.Method
import lclang.types.Types

class StringClass(fileVisitor: LCFileVisitor): LCClass("string", fileVisitor) {
    override val constructor: Method = method(returnType = Types.STRING) { list ->
        StringClass(list[0].toString(), this)
    }

    lateinit var string: String

    constructor(string: String, fileVisitor: LCFileVisitor): this(fileVisitor) {
        this.string = string

        globals["charAt"] = method(listOf(Types.INT), Types.STRING) { args ->
            string[args[0] as Int].toString()
        }

        globals["toArray"] = method(listOf(), Types.ARRAY) {
            ValueList(this@StringClass.fileVisitor).apply {
                for (c in string) add(Value(Types.CHAR, c))
            }
        }

        globals["toArray"] = method(listOf(Types.CHAR), Types.ARRAY) { args ->
            val parts = string.split(args[0] as Char)
            ValueList(this@StringClass.fileVisitor).apply {
                for(part in parts){
                    add(Value(Types.STRING, part))
                }
            }
        }

        globals["substring"] = method(listOf(Types.INT, Types.INT), Types.ARRAY) { args ->
            string.substring(args[0] as Int, args[1] as Int)
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