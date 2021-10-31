package lclang.statements

import lclang.Caller
import lclang.LCBaseExecutor
import lclang.VOID_VALUE
import lclang.Value
import lclang.libs.lang.BoolClass

class IfStatement(
    val condition: Expression,
    val onTrue: Statement,
    val onFalse: Statement?,
    line: Int,
    column: Int
): Statement(line, column) {
    override fun visit(prevCaller: Caller, visitor: LCBaseExecutor): Value {
        val caller = getCaller(prevCaller)
        val cond = condition.visit(caller, visitor).get(caller)
        if(cond!= BoolClass.FALSE) {
            return onTrue.visit(caller, visitor)
        }

        return onFalse?.visit(caller, visitor) ?: VOID_VALUE
    }
}