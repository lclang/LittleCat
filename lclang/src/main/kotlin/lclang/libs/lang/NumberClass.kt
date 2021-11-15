package lclang.libs.lang

import lclang.LCClass
import lclang.method
import lclang.types.Types
import kotlin.math.pow

open class NumberClass(name: String = "number", val number: Number = 0): LCClass(name) {
    init {
        extendsClass = if(name!="number") NumberClass() else null
        globals["toInt"] = method(returnType = Types.INT) { IntClass(number.toInt()) }
        globals["toDouble"] = method(returnType = Types.DOUBLE) { DoubleClass(number.toDouble()) }
        globals["toLong"] = method(returnType = Types.LONG) { LongClass(number.toLong()) }
        globals["toChar"] = method(returnType = Types.CHAR) { CharClass(number.toChar()) }
    }

    operator fun plus(numberClass: NumberClass): NumberClass =
        when{
            this is DoubleClass||numberClass is DoubleClass -> DoubleClass(number.toDouble()+numberClass.number.toDouble())
            this is LongClass||numberClass is LongClass -> LongClass(number.toLong()+numberClass.number.toLong())
            else -> IntClass(number.toInt()+numberClass.number.toInt())
        }

    operator fun minus(numberClass: NumberClass) =
        when{
            this is DoubleClass||numberClass is DoubleClass -> DoubleClass(number.toDouble()-numberClass.number.toDouble())
            this is LongClass||numberClass is LongClass -> LongClass(number.toLong()-numberClass.number.toLong())
            else -> IntClass(number.toInt()-numberClass.number.toInt())
        }

    operator fun times(numberClass: NumberClass) =
        when{
            this is DoubleClass||numberClass is DoubleClass -> DoubleClass(number.toDouble()*numberClass.number.toDouble())
            this is LongClass||numberClass is LongClass -> LongClass(number.toLong()*numberClass.number.toLong())
            else -> IntClass(number.toInt()*numberClass.number.toInt())
        }

    operator fun div(numberClass: NumberClass) = DoubleClass(number.toDouble()/numberClass.number.toDouble())
    fun pow(numberClass: NumberClass) = DoubleClass(number.toDouble().pow(numberClass.number.toDouble()))
    fun larger(numberClass: NumberClass) = BoolClass(number.toDouble() > numberClass.number.toDouble())
    fun largerEquals(numberClass: NumberClass) = BoolClass(number.toDouble() >= numberClass.number.toDouble())
    fun less(numberClass: NumberClass) = BoolClass(number.toDouble() < numberClass.number.toDouble())
    fun lessEquals(numberClass: NumberClass) = BoolClass(number.toDouble() <= numberClass.number.toDouble())
}