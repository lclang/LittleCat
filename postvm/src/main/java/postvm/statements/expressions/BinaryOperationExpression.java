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

        Link rightLink = right.visit(caller, visitor);
        if(rightLink.state != Link.State.NOTHING) return rightLink;
        PostVMClass rightClass = rightLink.get(caller);

        Link leftLink = left.visit(caller, visitor);
        if(leftLink.state != Link.State.NOTHING) return leftLink;
        PostVMClass leftClass = leftLink.get(caller);

        if(leftClass.canCast(NumberClass.INSTANCE) && rightClass.canCast(NumberClass.INSTANCE)) {
            NumberClass leftNumber = leftClass.cast(NumberClass.class);
            NumberClass rightNumber = rightClass.cast(NumberClass.class);

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

        if(leftClass instanceof StringClass || rightClass instanceof StringClass){
            switch (operation) {
                case ADD: return StringClass.get(leftClass.toString(caller)+rightClass.toString(caller)).createLink();
                case MULTIPLICATION:
                    if(rightClass instanceof IntClass ||leftClass instanceof IntClass)
                        return StringClass.get(rightClass instanceof IntClass ?
                                    String.format("%0" + ((IntClass) rightClass).value + "d", 0)
                                        .replace("0", leftClass.toString(caller))
                                :   String.format("%0" + ((IntClass) leftClass).value + "d", 0)
                                    .replace("0", rightClass.toString(caller))).createLink();
            }
        }

        if(rightClass instanceof ArrayClass && leftClass instanceof ArrayClass){
            ArrayClass leftArray = (ArrayClass) leftClass;
            ArrayClass rightArray = (ArrayClass) rightClass;
            if (operation == Operation.ADD) {
                return leftArray.merge(rightArray).createLink();
            }
        }

        if(rightClass instanceof BoolClass && leftClass instanceof BoolClass){
            BoolClass leftBool = (BoolClass) leftClass;
            BoolClass rightBool = (BoolClass) rightClass;
            switch (operation) {
                case OR: return BoolClass.get(leftBool.bool || rightBool.bool).createLink();
                case AND: return BoolClass.get(leftBool.bool && rightBool.bool).createLink();
            }
        }

         switch (operation) {
            case NULLABLE_OR : if(leftClass==NullClass.INSTANCE)
                return rightLink;
            else return leftLink;

            case ARRAY_ACCESS: {
                if(leftClass instanceof ArrayClass) {
                    if (rightClass instanceof IntClass)
                        return leftClass.cast(ArrayClass.class).get(rightClass.cast(IntClass.class).value).createLink();
                    else throw new LCLangTypeErrorException("invalid index: excepted int", caller);
                }else throw new LCLangTypeErrorException("excepted array or map", caller);
            }

            case EQUALS: return BoolClass.get(leftClass.equals(rightClass)).createLink();
            case NOT_EQUALS: return BoolClass.get(!leftClass.equals(rightClass)).createLink();

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
