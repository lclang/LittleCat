package lclang.statements

import lclang.Caller
import lclang.LCBaseExecutor
import lclang.VOID_VALUE
import lclang.Value

class ReturnExpression(
    val expression: Expression?,
    line: Int,
    column: Int
): Expression(line, column) {
    override fun visit(prevCaller: Caller, visitor: LCBaseExecutor): Value {
        val caller = getCaller(prevCaller)
        var value = VOID_VALUE
        if(expression!=null)
            value = expression.visit(caller, visitor)

        value.state = Value.State.RETURN
        return value
    }
}