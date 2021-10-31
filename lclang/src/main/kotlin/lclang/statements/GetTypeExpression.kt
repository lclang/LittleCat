package lclang.statements

import lclang.Caller
import lclang.LCBaseExecutor
import lclang.libs.lang.StringClass

class GetTypeExpression(
    val of: Expression,
    line: Int,
    column: Int
): Expression(line, column) {
    override fun visit(prevCaller: Caller, visitor: LCBaseExecutor) =
        StringClass(of.visit(getCaller(prevCaller), visitor).type.text).asValue()
}