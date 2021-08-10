package lclang.libs

import lclang.LCFileVisitor
import lclang.methods.LibraryMethod
import lclang.types.Types

class TestLibrary(output: StringBuilder): Library("test") {
    init {
        globals["println"] = object : LibraryMethod(listOf(Types.ANY), Types.VOID) {
            override fun callMethod(fileVisitor: LCFileVisitor, args: List<Any?>): Any? {
                output.append("${args[0]}\r\n")
                return null
            }
        }

        globals["print"] = object : LibraryMethod(listOf(Types.ANY), Types.VOID) {
            override fun callMethod(fileVisitor: LCFileVisitor, args: List<Any?>): Any? {
                output.append(args[0])
                return null
            }
        }
    }
}