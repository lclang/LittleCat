package lclang.statements

import lclang.Caller
import lclang.LCBaseExecutor
import lclang.Value
import lclang.methods.MethodImpl
import lclang.types.Type

class MethodStatement(
    val name: String,
    val args: Map<String, Type>,
    val returnType: Type,
    val statement: Statement,
    line: Int,
    column: Int
): Statement(line, column) {
    override fun visit(prevCaller: Caller, visitor: LCBaseExecutor): Value {
        return MethodImpl(visitor, args, returnType, statement).asValue()
    }
}