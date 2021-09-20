package lclang.libs.std.classes

import lclang.LCClass
import lclang.LCFileVisitor
import lclang.methods.LibraryMethod
import lclang.types.Types
import kotlin.math.ln
import kotlin.math.pow
import kotlin.math.sqrt

class MathClass(fileVisitor: LCFileVisitor): LCClass("math", fileVisitor)  {

    init {
        globals["sqrt"] = object: LibraryMethod(listOf(Types.DOUBLE), Types.DOUBLE) {
            override fun callMethod(fileVisitor: LCFileVisitor, args: List<Any?>): Any {
                return sqrt(args[0] as Double)
            }
        }

        globals["ln"] = object: LibraryMethod(listOf(Types.DOUBLE), Types.DOUBLE) {
            override fun callMethod(fileVisitor: LCFileVisitor, args: List<Any?>): Any {
                return ln(args[0] as Double)
            }
        }

        globals["sqrtN"] = object: LibraryMethod(listOf(Types.DOUBLE, Types.INT), Types.DOUBLE) {
            override fun callMethod(fileVisitor: LCFileVisitor, args: List<Any?>): Any {
                return (args[0] as Double).pow(1/args[1] as Int)
            }
        }
    }
}