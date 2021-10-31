package lclang.statements

import lclang.Caller
import lclang.LCBaseExecutor
import lclang.Value
import lclang.exceptions.LCLangNullPointerException
import lclang.exceptions.TypeErrorException
import lclang.libs.lang.BoolClass
import lclang.libs.lang.IntClass
import lclang.libs.lang.NumberClass

class UnaryOperationExpression(
    val expression: Expression,
    val operation: Operation,
    line: Int,
    column: Int
): Expression(line, column) {
    override fun visit(prevCaller: Caller, visitor: LCBaseExecutor): Value {
        val caller = getCaller(prevCaller)
        val leftValue = expression.visit(caller, visitor)
        val left = leftValue.get(caller)

        val value = when {
            //ctx.`is`!=null -> return BoolClass(Types.getType(root, ctx.type()).isAccept(leftType)).asValue()
            operation==Operation.NOT -> return BoolClass(left is BoolClass &&!left.bool).asValue()
            operation==Operation.NULL_CHECK-> if(left==null)
                throw LCLangNullPointerException(expression, caller)
            else return leftValue

            operation==Operation.UNARY_PLUS && left is NumberClass ->
                (left + IntClass(1)).asValue()

            operation==Operation.UNARY_MINUS && left is NumberClass ->
                (left - IntClass(1)).asValue()

            else -> throw TypeErrorException("Operation not supported", caller)
        }

        leftValue.set(caller, value)
        return value
    }

    enum class Operation {
        NULL_CHECK,
        UNARY_PLUS,
        UNARY_MINUS,
        NOT,
    }
}