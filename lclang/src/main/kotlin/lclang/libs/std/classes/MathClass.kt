package lclang.libs.std.classes

import lclang.LCClass
import lclang.double
import lclang.int
import lclang.libs.lang.classes.numbers.DoubleClass
import lclang.method
import lclang.types.Types
import kotlin.math.*

class MathClass : LCClass("math")  {

    init {
        globals["sqrt"] = method(listOf(Types.DOUBLE), Types.DOUBLE) {
            DoubleClass.get(sqrt(it[0].double().value))
        }

        globals["ln"] = method(listOf(Types.DOUBLE), Types.DOUBLE) {
            DoubleClass.get(ln(it[0].double().value))
        }

        globals["abs"] = method(listOf(Types.DOUBLE), Types.DOUBLE) {
            DoubleClass.get(abs(it[0].double().value))
        }

        globals["acos"] = method(listOf(Types.DOUBLE), Types.DOUBLE) {
            DoubleClass.get(acos(it[0].double().value))
        }

        globals["asin"] = method(listOf(Types.DOUBLE), Types.DOUBLE) {
            DoubleClass.get(asin(it[0].double().value))
        }

        globals["cos"] = method(listOf(Types.DOUBLE), Types.DOUBLE) {
            DoubleClass.get(cos(it[0].double().value))
        }

        globals["sin"] = method(listOf(Types.DOUBLE), Types.DOUBLE) {
            DoubleClass.get(sin(it[0].double().value))
        }

        globals["toRadians"] = method(listOf(Types.DOUBLE), Types.DOUBLE) {
            DoubleClass.get(Math.toRadians(it[0].double().value))
        }

        globals["toDegrees"] = method(listOf(Types.DOUBLE), Types.DOUBLE) {
            DoubleClass.get(Math.toDegrees(it[0].double().value))
        }

        globals["log"] = method(listOf(Types.DOUBLE, Types.DOUBLE), Types.DOUBLE) {
            DoubleClass.get(log(it[0].double().value, it[1].double().value))
        }

        globals["sqrtN"] = method(listOf(Types.DOUBLE, Types.INT), Types.DOUBLE) {
            DoubleClass.get(it[0].double().value.pow(1/it[1].int().value))
        }
    }
}