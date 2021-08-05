package lclang.libs

import lclang.LCFileVisitor
import lclang.types.Type
import lclang.methods.Method
import java.lang.StringBuilder

class TestLibrary(output: StringBuilder): Library("test") {
    init {
        globals["println"] = object : Method(listOf(Type.ANY), Type.VOID) {
            override fun call(fileVisitor: LCFileVisitor, args: List<Any?>): Any? {
                output.append("${args[0]}\n")
                return null
            }
        }

        globals["print"] = object : Method(listOf(Type.ANY), Type.VOID) {
            override fun call(fileVisitor: LCFileVisitor, args: List<Any?>): Any? {
                output.append(args[0])
                return null
            }
        }
    }
}