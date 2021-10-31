package lclang.statements

import lclang.Caller
import lclang.LCBaseExecutor
import lclang.VOID_VALUE
import lclang.Value

class BlockStatement(
    val statements: Array<Statement>,
    line: Int,
    column: Int
): Statement(line, column) {
    override fun visit(prevCaller: Caller, visitor: LCBaseExecutor): Value {
        for(stmt in statements) {
            val caller = stmt.getCaller(prevCaller)
            val value = stmt.visit(caller, visitor)
            if (value.state!= Value.State.NOTHING)
                return value
            else value.get(caller)
        }

        return VOID_VALUE
    }
}