package lclang.statements

import lclang.Caller
import lclang.LCBaseExecutor
import lclang.Value

class ValueExpression(
    val value: Value,
    line: Int,
    column: Int
): Expression(line, column) {
    override fun visit(prevCaller: Caller, visitor: LCBaseExecutor) = value
}