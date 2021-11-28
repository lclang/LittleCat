package lclang.statements.expressions;

import lclang.Caller;
import lclang.LCBaseExecutor;
import lclang.LCClass;
import lclang.Value;
import lclang.exceptions.LCLangRuntimeException;
import lclang.exceptions.LCLangTypeErrorException;
import lclang.libs.lang.classes.ArrayClass;
import lclang.libs.lang.classes.BoolClass;
import lclang.libs.lang.classes.NullClass;
import lclang.libs.lang.classes.StringClass;
import lclang.libs.lang.classes.numbers.IntClass;
import lclang.libs.lang.classes.numbers.NumberClass;

public class BinaryOperationExpression extends Expression {
    public final Expression left;
    public final Expression right;
    public final Operation operation;

    public BinaryOperationExpression(Expression left, Expression right, Operation operation, int line) {
        super(line);
        this.left = left;
        this.right = right;
        this.operation = operation;
    }

    @Override
    public Value visit(Caller prevCaller, LCBaseExecutor visitor) throws LCLangRuntimeException {
        Caller caller = getCaller(prevCaller);
        Value rightValue = right.visit(caller, visitor);
        LCClass right = rightValue.get.invoke(caller);

        Value leftValue = left.visit(caller, visitor);
        LCClass left = leftValue.get.invoke(caller);


        if(left instanceof NumberClass && right instanceof NumberClass) {
            NumberClass leftNumber = (NumberClass) left;
            NumberClass rightNumber = (NumberClass) right;

            switch (operation) {
                case POW: return leftNumber.pow(rightNumber).asValue();
                case LESS: return leftNumber.less(rightNumber).asValue();
                case LESS_EQUALS: return leftNumber.lessEquals(rightNumber).asValue();
                case LARGER: return leftNumber.larger(rightNumber).asValue();
                case LARGER_EQUALS: return leftNumber.largerEquals(rightNumber).asValue();
                case MULTIPLICATION: return leftNumber.multiplication(rightNumber).asValue();
                case ADD: return leftNumber.add(rightNumber).asValue();
                case MINUS: return leftNumber.minus(rightNumber).asValue();
                case DIVISION: return leftNumber.div(rightNumber).asValue();
            }
        }

        if(left instanceof StringClass || right instanceof StringClass){
            switch (operation) {
                case ADD: return StringClass.get(left.toString(caller)+right).asValue();
                case MULTIPLICATION:
                    if(right instanceof IntClass ||left instanceof IntClass)
                        return StringClass.get(right instanceof IntClass ?
                                    String.format("%0" + ((IntClass) right).value + "d", 0)
                                        .replace("0", left.toString(caller))
                                :   String.format("%0" + ((IntClass) left).value + "d", 0)
                                    .replace("0", right.toString(caller))).asValue();
            }
        }

        if(right instanceof ArrayClass && left instanceof ArrayClass){
            ArrayClass leftArray = (ArrayClass) left;
            ArrayClass rightArray = (ArrayClass) right;
            if (operation == Operation.ADD) {
                return leftArray.merge(rightArray).asValue();
            }
        }

        if(right instanceof BoolClass && left instanceof BoolClass){
            BoolClass leftBool = (BoolClass) left;
            BoolClass rightBool = (BoolClass) right;
            switch (operation) {
                case OR: return BoolClass.get(leftBool.bool||rightBool.bool).asValue();
                case AND: return BoolClass.get(leftBool.bool&&rightBool.bool).asValue();
            }
        }

         switch (operation) {
            case NULLABLE_OR : if(left.equals(NullClass.instance))
                return rightValue;
            else return leftValue;

            case ARRAY_ACCESS: {
                if(left instanceof ArrayClass) {
                    if (right instanceof IntClass)
                        return ((ArrayClass) left).get(((IntClass) right).value).asValue();
                    else throw new LCLangTypeErrorException("invalid index: excepted int", caller);
                }/*else if(left instanceof Map<*, *>){
                       left[right] as Value
                }*/else throw new LCLangTypeErrorException("excepted array or map", caller);
            }

            case EQUALS: return BoolClass.get(left == right).asValue();
            case NOT_EQUALS: return BoolClass.get(left != right).asValue();

            default: throw new LCLangTypeErrorException("Operation not supported", caller);
        }
    }

    public enum Operation {
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
        NULLABLE_OR
    }
}
