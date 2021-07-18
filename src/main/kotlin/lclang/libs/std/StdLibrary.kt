package lclang.libs.std

import lclang.Type
import lclang.libs.Library
import lclang.methods.Method

class StdLibrary: Library() {
    init {
        methods["println"] = object: Method(listOf(Type.ANY), Type.VOID) {
            override fun call(args: List<Any?>): Any? {
                println(args[0])

                return null
            }
        }
        methods["print"] = object: Method(listOf(Type.ANY), Type.VOID) {
            override fun call(args: List<Any?>): Any? {
                print(args[0])

                return null
            }
        }
    }
}