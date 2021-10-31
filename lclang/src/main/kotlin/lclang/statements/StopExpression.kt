package lclang.statements

import lclang.Caller
import lclang.LCBaseExecutor
import lclang.Value
import lclang.types.Types

class StopExpression(
    line: Int,
    column: Int
) : Expression(line, column) {
    override fun visit(prevCaller: Caller, visitor: LCBaseExecutor) = Value(Types.VOID, null, Value.State.STOP)
}