package lclang.statements

import lclang.Caller
import lclang.LCBaseExecutor
import lclang.Value
import lclang.libs.lang.BoolClass

class IfExpression(
    val condition: Expression,
    val onTrue: Expression,
    val onFalse: Expression,
    line: Int,
    column: Int
): Expression(line, column) {
    override fun visit(prevCaller: Caller, visitor: LCBaseExecutor): Value {
        val caller = getCaller(prevCaller)
        val cond = condition.visit(caller, visitor).get(caller)
        if(cond!=BoolClass.FALSE){
            return onTrue.visit(caller, visitor)
        }

        return onFalse.visit(caller, visitor)
    }
}