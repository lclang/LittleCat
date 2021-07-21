package lclang.lang

import lclang.*
import lclang.methods.Method

class StringClass(val string: String, parent: LCFileVisitor): LCClass("string", parent, string) {
    init {
        methods["charAt"] = object: Method(listOf(Type.INT), Type.STRING) {
            override fun call(fileVisitor: LCFileVisitor, args: List<Any?>): Any {
                return string[args[0] as Int].toString()
            }
        }
        methods["toArray"] = object: Method(listOf(), Type.ARRAY) {
            override fun call(fileVisitor: LCFileVisitor, args: List<Any?>): Any {
                val arr: ValueList = ValueList();
                for (c in string) arr.add(Value(Type.CHAR, c))
                return arr
            }
        }
        methods["find"] = object: Method(listOf(Type.CHAR), Type.INT) {
            override fun call(fileVisitor: LCFileVisitor, args: List<Any?>): Any? {
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
    override fun hashCode(): Int = string.hashCode()
}