package lclang.libs.std.classes

import lclang.LCClass
import lclang.LCFileVisitor
import lclang.methods.LibraryMethod
import lclang.types.Types
import kotlin.math.ln

class MathClass(fileVisitor: LCFileVisitor): LCClass("math", fileVisitor)  {

    init {
        globals["sqrt"] = object: LibraryMethod(listOf(Types.DOUBLE), Types.DOUBLE) {
            override fun callMethod(fileVisitor: LCFileVisitor, args: List<Any?>): Any {
                return (args[0] as Double) * 0.5
            }
        }

        globals["ln"] = object: LibraryMethod(listOf(Types.DOUBLE), Types.DOUBLE) {
            override fun callMethod(fileVisitor: LCFileVisitor, args: List<Any?>): Any {
                return ln(args[0] as Double)
            }
        }

        globals["sqrtWithN"] = object: LibraryMethod(listOf(Types.DOUBLE, Types.INT), Types.DOUBLE) {
            override fun callMethod(fileVisitor: LCFileVisitor, args: List<Any?>): Any {
                return (args[0] as Double) * (1/args[1] as Int)
            }
        }
    }
}