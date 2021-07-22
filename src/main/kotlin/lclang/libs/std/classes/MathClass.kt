package lclang.libs.std.classes

import lclang.LCClass
import lclang.LCFileVisitor
import lclang.Type
import lclang.methods.Method
import kotlin.math.sqrt

class MathClass(fileVisitor: LCFileVisitor): LCClass("math", fileVisitor)  {

    init {
        methods["sqrt"] = object: Method(listOf(Type.DOUBLE), Type.DOUBLE) {
            override fun call(fileVisitor: LCFileVisitor, args: List<Any?>): Any {
                return sqrt(args[0] as Double)
            }
        }
    }
}