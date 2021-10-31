package lclang.statements

import lclang.Caller
import lclang.LCBaseExecutor
import lclang.VOID_VALUE
import lclang.Value
import lclang.libs.lang.BoolClass

class WhileStatement(
    val condition: Expression,
    val body: Statement?,
    line: Int,
    column: Int
): Statement(line, column) {
    override fun visit(prevCaller: Caller, visitor: LCBaseExecutor): Value {
        val caller = getCaller(prevCaller)
        if(body==null) {
            while(condition.visit(caller, visitor).get(caller)!= BoolClass.FALSE) {}
        }else while(true) {
            if(condition.visit(caller, visitor).get(caller)== BoolClass.FALSE) break

            val value = body.visit(caller, visitor)
            if(value.state==Value.State.RETURN)
                return value
            else if(value.state==Value.State.STOP)
                break
        }

        return VOID_VALUE
    }
}