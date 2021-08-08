package lclang.libs.std.classes

import lclang.LCClass
import lclang.LCFileVisitor
import lclang.types.Types
import lclang.methods.Method
import kotlin.math.sqrt

class MathClass(fileVisitor: LCFileVisitor): LCClass("math", fileVisitor)  {

    init {
        globals["sqrt"] = object: Method(listOf(Types.DOUBLE), Types.DOUBLE) {
            override fun call(fileVisitor: LCFileVisitor, args: List<Any?>): Any {
                return sqrt(args[0] as Double)
            }
        }
    }
}