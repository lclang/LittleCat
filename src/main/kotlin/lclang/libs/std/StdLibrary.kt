package lclang.libs.std

import lclang.Type
import lclang.ValueList
import lclang.libs.Library
import lclang.methods.Method
import kotlin.system.exitProcess
import java.util.*

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

        methods["readLine"] = object: Method(listOf(), Type.STRING) {
            override fun call(args: List<Any?>): Any? {
                val scanner = Scanner(System.`in`)
                return scanner.nextLine()
            }
        }

        methods["printError"] = object: Method(listOf(Type.ANY), Type.VOID) {
            override fun call(args: List<Any?>): Any? {
                error(args[0].toString());
            }
        }

        methods["exit"] = object: Method(listOf(Type.INT), Type.VOID) {
            override fun call(args: List<Any?>): Any? {
                exitProcess(args[0] as Int);
            }
        }

        methods["time"] = object: Method(listOf(), Type.VOID) {
            override fun call(args: List<Any?>): Any {
                return System.currentTimeMillis() / 1000
            }
        }

        methods["asString"] = object: Method(listOf(Type.ARRAY), Type.VOID) {
            override fun call(args: List<Any?>): Any {
                val a = args[0] as ValueList
                var str = ""
                for((i, el) in a.withIndex()){
                    str += el.get().toString() + if(a.size != i+1) ", " else ""
                }
                return str
            }
        }
    }
}