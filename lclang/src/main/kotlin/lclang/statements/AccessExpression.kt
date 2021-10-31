package lclang.statements

import lclang.Caller
import lclang.LCBaseExecutor
import lclang.Value
import lclang.exceptions.LCLangNullPointerException

class AccessExpression(
    val expression: Expression,
    val variable: VariableExpression,
    line: Int,
    column: Int
): Expression(line, column) {
    override fun visit(prevCaller: Caller, visitor: LCBaseExecutor): Value {
        val caller = getCaller(prevCaller)
        val value = expression.visit(caller, visitor).get(caller) ?:
                throw LCLangNullPointerException(expression, caller)
        return variable.visit(caller, value.executor)
    }
}