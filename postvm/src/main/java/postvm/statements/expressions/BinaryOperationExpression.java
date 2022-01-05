package postvm.statements.expressions;

import postvm.Caller;
import postvm.Link;
import postvm.PostVMExecutor;
import postvm.exceptions.LCLangRuntimeException;
import postvm.exceptions.LCLangTypeErrorException;
import postvm.library.classes.*;
import postvm.library.classes.numbers.IntClass;
import postvm.library.classes.numbers.NumberClass;

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
    public Link visit(Caller prevCaller, PostVMExecutor visitor) throws LCLangRuntimeException {
        Caller caller = getCaller(prevCaller);

        Link rightValue = right.visit(caller, visitor);
        PostVMClass right = rightValue.get(caller);

        Link leftValue = left.visit(caller, visitor);
        PostVMClass left = leftValue.get(caller);


        if(left.extendsClass instanceof NumberClass && right.extendsClass instanceof NumberClass) {
            NumberClass leftNumber = (NumberClass) left.extendsClass;
            NumberClass rightNumber = (NumberClass) right.extendsClass;

            switch (operation) {
                case POW: return leftNumber.pow(rightNumber).createLink();
                case LESS: return leftNumber.less(rightNumber).createLink();
                case LESS_EQUALS: return leftNumber.lessEquals(rightNumber).createLink();
                case LARGER: return leftNumber.larger(rightNumber).createLink();
                case LARGER_EQUALS: return leftNumber.largerEquals(rightNumber).createLink();
                case MULTIPLICATION: return leftNumber.multiplication(rightNumber).createLink();
                case ADD: return leftNumber.add(rightNumber).createLink();
                case MINUS: return leftNumber.minus(rightNumber).createLink();
                case DIVISION: return leftNumber.div(rightNumber).createLink();
            }
        }

        if(left instanceof StringClass || right instanceof StringClass){
            switch (operation) {
                case ADD: return StringClass.get(left.toString(caller)+right.toString(caller)).createLink();
                case MULTIPLICATION:
                    if(right instanceof IntClass ||left instanceof IntClass)
                        return StringClass.get(right instanceof IntClass ?
                                    String.format("%0" + ((IntClass) right).value + "d", 0)
                                        .replace("0", left.toString(caller))
                                :   String.format("%0" + ((IntClass) left).value + "d", 0)
                                    .replace("0", right.toString(caller))).createLink();
            }
        }

        if(right instanceof ArrayClass && left instanceof ArrayClass){
            ArrayClass leftArray = (ArrayClass) left;
            ArrayClass rightArray = (ArrayClass) right;
            if (operation == Operation.ADD) {
                return leftArray.merge(rightArray).createLink();
            }
        }

        if(right instanceof BoolClass && left instanceof BoolClass){
            BoolClass leftBool = (BoolClass) left;
            BoolClass rightBool = (BoolClass) right;
            switch (operation) {
                case OR: return BoolClass.get(leftBool.bool||rightBool.bool).createLink();
                case AND: return BoolClass.get(leftBool.bool&&rightBool.bool).createLink();
            }
        }

         switch (operation) {
            case NULLABLE_OR : if(left==NullClass.INSTANCE)
                return rightValue;
            else return leftValue;

            case ARRAY_ACCESS: {
                if(left instanceof ArrayClass) {
                    if (right instanceof IntClass)
                        return left.cast(ArrayClass.class).get(right.cast(IntClass.class).value).createLink();
                    else throw new LCLangTypeErrorException("invalid index: excepted int", caller);
                }else throw new LCLangTypeErrorException("excepted array or map", caller);
            }

            case EQUALS: return BoolClass.get(left.equals(right)).createLink();
            case NOT_EQUALS: return BoolClass.get(!left.equals(right)).createLink();

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
