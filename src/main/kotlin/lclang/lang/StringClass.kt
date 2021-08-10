package lclang.lang

import lclang.LCClass
import lclang.LCFileVisitor
import lclang.Value
import lclang.ValueList
import lclang.methods.LibraryMethod
import lclang.types.Types

class StringClass(val string: String, fileVisitor: LCFileVisitor): LCClass("string", fileVisitor) {
    init {
        globals["charAt"] = object: LibraryMethod(listOf(Types.INT), Types.STRING) {
            override fun callMethod(fileVisitor: LCFileVisitor, args: List<Any?>): Any {
                return string[args[0] as Int].toString()
            }
        }

        globals["toArray"] = object: LibraryMethod(listOf(), Types.ARRAY) {
            override fun callMethod(fileVisitor: LCFileVisitor, args: List<Any?>): Any {
                val arr = ValueList(this@StringClass.fileVisitor)
                for (c in string) arr.add(Value(Types.CHAR, c))
                return arr
            }
        }

        globals["toArray"] = object: LibraryMethod(listOf(Types.CHAR), Types.ARRAY) {
            override fun callMethod(fileVisitor: LCFileVisitor, args: List<Any?>): Any {
                val arr = ValueList(this@StringClass.fileVisitor)
                for(el in string.split(args[0] as Char)){
                    arr.add(Value(Types.STRING, el))
                }
                return arr
            }
        }

        globals["find"] = object: LibraryMethod(listOf(Types.CHAR), Types.INT) {
            override fun callMethod(fileVisitor: LCFileVisitor, args: List<Any?>): Any? {
                for ((i, c) in string.withIndex()){
                    if(c == (args[0] as CharClass).char){
                        return i
                    }
                }
                return null
            }
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