package lclang.statements

import lclang.Caller
import lclang.LCBaseExecutor

class VariableExpression(
    val name: String,
    line: Int,
    column: Int
): Expression(line, column) {
    override fun visit(prevCaller: Caller, visitor: LCBaseExecutor) = visitor.getLink(name)
}