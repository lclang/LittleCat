package lclang.statements

import lclang.Caller
import lclang.LCBaseExecutor
import lclang.VOID_VALUE
import lclang.Value

class ContainerExpression(
    val statements: Array<Statement>,
    line: Int,
    column: Int
): Expression(line, column) {
    override fun visit(prevCaller: Caller, visitor: LCBaseExecutor): Value {
        for(stmt in statements) {
            val caller = stmt.getCaller(prevCaller)
            val value = stmt.visit(caller, visitor)
            if(value.state!= Value.State.NOTHING) {
                if(value.state== Value.State.RETURN)
                    value.state = Value.State.NOTHING

                return value
            }else value.get(caller)
        }

        return VOID_VALUE
    }
}