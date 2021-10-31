package lclang.statements

import lclang.Caller
import lclang.LCBaseExecutor
import lclang.Value
import lclang.lclangParser

class LambdaExpression(
    val args: Array<lclangParser.ArgContext>,
    val returnType: lclangParser.TypeContext,
    val statement: Statement, line: Int, column: Int
): Expression(line, column) {
    override fun visit(prevCaller: Caller, visitor: LCBaseExecutor): Value {
        TODO("Not yet implemented")
    }
}