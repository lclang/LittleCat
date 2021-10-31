package lclang.statements

import lclang.Caller
import lclang.LCBaseExecutor
import lclang.Value

class AssignExpression(val left: Expression,
                       val right: Expression,
                       line: Int,
                       column: Int
): Expression(line, column) {

    override fun visit(prevCaller: Caller, visitor: LCBaseExecutor): Value {
        val caller = getCaller(prevCaller)
        val settableValue = left.visit(caller, visitor)
        val value = right.visit(caller, visitor)

        settableValue.set(caller, value)
        return value
    }
}