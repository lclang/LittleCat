package lclang.libs.std.classes

import lclang.LCClass
import lclang.double
import lclang.int
import lclang.libs.lang.DoubleClass
import lclang.method
import lclang.types.Types
import kotlin.math.*

class MathClass : LCClass("math")  {

    init {
        globals["sqrt"] = method(listOf(Types.DOUBLE), Types.DOUBLE) {
            DoubleClass(sqrt(it[0].double().double))
        }

        globals["ln"] = method(listOf(Types.DOUBLE), Types.DOUBLE) {
            DoubleClass(ln(it[0].double().double))
        }

        globals["abs"] = method(listOf(Types.DOUBLE), Types.DOUBLE) {
            DoubleClass(abs(it[0].double().double)) }

        globals["acos"] = method(listOf(Types.DOUBLE), Types.DOUBLE) {
            DoubleClass(acos(it[0].double().double) )
        }

        globals["asin"] = method(listOf(Types.DOUBLE), Types.DOUBLE) {
            DoubleClass(asin(it[0].double().double))
        }

        globals["cos"] = method(listOf(Types.DOUBLE), Types.DOUBLE) {
            DoubleClass(cos(it[0].double().double))
        }

        globals["sin"] = method(listOf(Types.DOUBLE), Types.DOUBLE) {
            DoubleClass(sin(it[0].double().double))
        }

        globals["toRadians"] = method(listOf(Types.DOUBLE), Types.DOUBLE) {
            DoubleClass(Math.toRadians(it[0].double().double))
        }

        globals["toDegrees"] = method(listOf(Types.DOUBLE), Types.DOUBLE) {
            DoubleClass(Math.toDegrees(it[0].double().double))
        }

        globals["log"] = method(listOf(Types.DOUBLE, Types.DOUBLE), Types.DOUBLE) {
            DoubleClass(log(it[0].double().double, it[1].double().double))
        }

        globals["sqrtN"] = method(listOf(Types.DOUBLE, Types.INT), Types.DOUBLE) {
            DoubleClass(it[0].double().double.pow(1/it[1].int().int))
        }
    }
}