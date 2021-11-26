package lclang.statements

import lclang.Caller
import lclang.LCBaseExecutor
import lclang.Value
import lclang.exceptions.TypeErrorException
import lclang.libs.lang.classes.ArrayClass
import lclang.libs.lang.classes.BoolClass
import lclang.libs.lang.classes.NullClass
import lclang.libs.lang.classes.StringClass
import lclang.libs.lang.classes.numbers.IntClass
import lclang.libs.lang.classes.numbers.NumberClass
import lclang.statements.expressions.Expression

open class BinaryOperationExpression(
    val left: Expression,
    val right: Expression,
    val operation: Operation,
    line: Int,
): Expression(line) {
    override fun visit(prevCaller: Caller, visitor: LCBaseExecutor): Value {
        val caller = getCaller(prevCaller)
        val rightValue = right.visit(caller, visitor)
        val rightType = rightValue.type
        val right = rightValue.get(caller)

        val leftValue = left.visit(caller, visitor)
        val leftType = leftValue.type
        val left = leftValue.get(caller)


        if(left is NumberClass &&right is NumberClass) {
            when(operation) {
                Operation.POW -> return left.pow(right).asValue()
                Operation.LESS -> return left.less(right).asValue()
                Operation.LESS_EQUALS -> return left.lessEquals(right).asValue()
                Operation.LARGER -> return left.larger(right).asValue()
                Operation.LARGER_EQUALS -> return left.largerEquals(right).asValue()
                Operation.MULTIPLICATION -> return left.multiplication(right).asValue()
                Operation.ADD -> return left.add(right).asValue()
                Operation.MINUS -> return left.minus(right).asValue()
                Operation.DIVISION -> return left.div(right).asValue()
                else -> Unit
            }
        }

        if(left is StringClass || right is StringClass){
            when {
                operation== Operation.ADD -> return StringClass.get(left.toString(caller)+right).asValue()
                operation== Operation.MULTIPLICATION &&right is IntClass ||left is IntClass ->
                    return StringClass.get(if(right is IntClass)
                        left.toString(caller).repeat(right.value)
                    else right.toString(caller).repeat((left as IntClass).value)).asValue()
            }
        }

        if(right is ArrayClass &&left is ArrayClass){
            when(operation) {
                Operation.ADD -> return left.merge(right).asValue()
                else -> Unit
            }
        }

        if(right is BoolClass &&left is BoolClass){
            when (operation) {
                Operation.OR -> return BoolClass.get(left.bool||right.bool).asValue()
                Operation.AND -> return BoolClass.get(left.bool&&right.bool).asValue()
                else -> Unit
            }
        }

        return when (operation) {
            Operation.NULLABLE_OR -> if(left== NullClass.NULL) rightValue else leftValue
            Operation.ARRAY_ACCESS -> {
                return if(left is ArrayClass) {
                    if (right is IntClass)
                        left[right.value].asValue()
                    else throw TypeErrorException("invalid index: excepted int", caller)
                }else if(left is Map<*, *>){
                    left[right] as Value
                }else throw TypeErrorException("excepted array or map", caller)
            }

            Operation.EQUALS -> BoolClass.get(left == right).asValue()
            Operation.NOT_EQUALS -> BoolClass.get(left != right).asValue()

            else -> {
                throw TypeErrorException("Unsupported operand types: $leftType " +
                        "$operation $rightType", caller)
            }
        }
    }

    enum class Operation {
        ARRAY_ACCESS,
        OR,
        AND,
        EQUALS,
        NOT_EQUALS,
        LESS,
        LESS_EQUALS,
        LARGER,
        LARGER_EQUALS,
        MULTIPLICATION,
        DIVISION,
        ADD,
        MINUS,
        POW,
        NULLABLE_OR,
    }
}