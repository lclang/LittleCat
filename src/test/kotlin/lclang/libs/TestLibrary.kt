package lclang.libs

import lclang.LCFileVisitor
import lclang.Type
import lclang.methods.Method
import java.lang.StringBuilder

class TestLibrary(output: StringBuilder): Library("test") {
    init {
        variables["println"] = object : Method(listOf(Type.ANY), Type.VOID) {
            override fun call(fileVisitor: LCFileVisitor, args: List<Any?>): Any? {
                output.append("${args[0]}\n")
                return null
            }
        }

        variables["print"] = object : Method(listOf(Type.ANY), Type.VOID) {
            override fun call(fileVisitor: LCFileVisitor, args: List<Any?>): Any? {
                output.append(args[0])
                return null
            }
        }
    }
}