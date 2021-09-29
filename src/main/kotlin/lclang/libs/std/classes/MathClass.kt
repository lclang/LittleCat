package lclang.libs.std.classes

import lclang.LCClass
import lclang.method
import lclang.types.Types
import kotlin.math.*

class MathClass : LCClass("math")  {

    init {
        globals["sqrt"] = method(listOf(Types.DOUBLE), Types.DOUBLE) { sqrt(it[0] as Double) }
        globals["ln"] = method(listOf(Types.DOUBLE), Types.DOUBLE) { ln(it[0] as Double) }
        globals["abs"] = method(listOf(Types.DOUBLE), Types.DOUBLE) { abs(it[0] as Double) }
        globals["acos"] = method(listOf(Types.DOUBLE), Types.DOUBLE) { acos(it[0] as Double) }
        globals["asin"] = method(listOf(Types.DOUBLE), Types.DOUBLE) { asin(it[0] as Double) }
        globals["cos"] = method(listOf(Types.DOUBLE), Types.DOUBLE) { cos(it[0] as Double) }
        globals["sin"] = method(listOf(Types.DOUBLE), Types.DOUBLE) { sin(it[0] as Double) }
        globals["toRadians"] = method(listOf(Types.DOUBLE), Types.DOUBLE) { Math.toRadians(it[0] as Double) }
        globals["toDegrees"] = method(listOf(Types.DOUBLE), Types.DOUBLE) { Math.toDegrees(it[0] as Double) }
        globals["log"] = method(listOf(Types.DOUBLE, Types.DOUBLE), Types.DOUBLE) { log(it[0] as Double, it[1] as Double) }
        globals["sqrtN"] = method(listOf(Types.DOUBLE, Types.INT), Types.DOUBLE) {
            (it[0] as Double).pow(1/it[1] as Int)
        }
    }
}