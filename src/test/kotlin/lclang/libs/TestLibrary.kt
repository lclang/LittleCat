package lclang.libs

import lclang.LCFileVisitor
import lclang.types.Types
import lclang.methods.Method
import java.lang.StringBuilder

class TestLibrary(output: StringBuilder): Library("test") {
    init {
        globals["println"] = object : Method(listOf(Types.ANY), Types.VOID) {
            override fun call(fileVisitor: LCFileVisitor, args: List<Any?>): Any? {
                output.append("${args[0]}\r\n")
                return null
            }
        }

        globals["print"] = object : Method(listOf(Types.ANY), Types.VOID) {
            override fun call(fileVisitor: LCFileVisitor, args: List<Any?>): Any? {
                output.append(args[0])
                return null
            }
        }
    }
}