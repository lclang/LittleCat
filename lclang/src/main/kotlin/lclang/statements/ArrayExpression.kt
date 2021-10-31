package lclang.statements

import lclang.Caller
import lclang.LCBaseExecutor
import lclang.Value
import lclang.exceptions.TypeErrorException
import lclang.libs.lang.ArrayClass

class ArrayExpression(
    val array: List<Expression>,
    line: Int,
    column: Int
): Expression(line, column) {
    override fun visit(prevCaller: Caller, visitor: LCBaseExecutor): Value {
        val caller = getCaller(prevCaller)
        val arrayClass = ArrayClass(array.map { it.visit(caller, visitor) })
        val value = arrayClass.asValue()
        value.set = { c, it ->
            val otherArray = it.get(c)
            if(otherArray !is ArrayClass) throw TypeErrorException("Value is not array", c)

            for((i, expression) in array.withIndex()){
                expression.visit(c, visitor).set(c, otherArray[i])
            }
        }

        return value
    }
}