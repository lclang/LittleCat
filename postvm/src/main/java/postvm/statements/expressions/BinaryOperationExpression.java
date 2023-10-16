package postvm.statements.expressions;

import postvm.Link;
import postvm.PostVMExecutor;
import postvm.classes.PostVMClassInstance;
import postvm.exceptions.LCLangRuntimeException;
import postvm.exceptions.LCLangTypeErrorException;
import postvm.library.classes.*;
import postvm.library.classes.NumberClassInstance;

public class BinaryOperationExpression extends Expression {
    public final Expression left;
    public final Expression right;
    public final int operation;

    public BinaryOperationExpression(Expression left, Expression right, int operation, int line) {
        super(line);
        this.left = left;
        this.right = right;
        this.operation = operation;
    }

    @Override
    public Link visit(int prevCaller, PostVMExecutor visitor) throws LCLangRuntimeException {
        int caller = getCaller(prevCaller);

        Link rightLink = right.visit(caller, visitor);
        if(rightLink.state!=Link.State.NOTHING) return rightLink;
        PostVMClassInstance rightClass = rightLink.get();

        Link leftLink = left.visit(caller, visitor);
        if(leftLink.state!=Link.State.NOTHING) return leftLink;
        PostVMClassInstance leftClass = leftLink.get();

        if(leftClass.prototype.canCast(NumberClassInstance.PROTOTYPE) && rightClass.prototype.canCast(NumberClassInstance.PROTOTYPE)) {
            NumberClassInstance leftNumber = (NumberClassInstance) leftClass;
            NumberClassInstance rightNumber = (NumberClassInstance) rightClass;

            switch (operation) {
                case Operation.POW: return new Link(leftNumber.pow(rightNumber));
                case Operation.LESS: return new Link(leftNumber.less(rightNumber));
                case Operation.LESS_EQUALS: return new Link(leftNumber.lessEquals(rightNumber));
                case Operation.LARGER: return new Link(leftNumber.larger(rightNumber));
                case Operation.LARGER_EQUALS: return new Link(leftNumber.largerEquals(rightNumber));
                case Operation.MULTIPLICATION: return new Link(leftNumber.multiplication(rightNumber));
                case Operation.ADD: return new Link(leftNumber.add(rightNumber));
                case Operation.MINUS: return new Link(leftNumber.minus(rightNumber));
                case Operation.DIVISION: return new Link(leftNumber.div(rightNumber));
                case Operation.BINARY_AND: return new Link(leftNumber.binaryAnd(rightNumber));
                case Operation.BINARY_OR: return new Link(leftNumber.binaryOr(rightNumber));
                case Operation.BINARY_XOR: return new Link(leftNumber.binaryXOr(rightNumber));
                case Operation.BINARY_LEFT_SHIFT: return new Link(leftNumber.binaryLeftShift(rightNumber));
                case Operation.BINARY_RIGHT_SHIFT: return new Link(leftNumber.binaryRightShift(rightNumber));
            }
        }

        switch (operation) {
            case Operation.ADD:
                if(leftClass instanceof StringClassInstance || rightClass instanceof StringClassInstance)
                    return new Link(StringClassInstance.get(leftClass.toString(caller)+rightClass.toString(caller)));

                if(leftClass instanceof ArrayClassInstance && rightClass instanceof ArrayClassInstance)
                    return ((ArrayClassInstance) leftClass).merge((ArrayClassInstance) rightClass).createLink();

            case Operation.MULTIPLICATION:
                if((leftClass instanceof StringClassInstance && rightClass instanceof NumberClassInstance) ||
                        (rightClass instanceof StringClassInstance && leftClass instanceof NumberClassInstance))
                    return new Link(StringClassInstance.get(rightClass instanceof NumberClassInstance ?
                            String.format("%0" + ((NumberClassInstance) rightClass).value + "d", 0)
                                    .replace("0", leftClass.toString(caller))
                            :   String.format("%0" + ((NumberClassInstance) leftClass).value + "d", 0)
                            .replace("0", rightClass.toString(caller))));

            case Operation.OR: return (leftClass == VoidClassInstance.INSTANCE || leftClass.classId == BoolClassInstance.FALSE ?
                    rightClass: leftClass).createLink();
            case Operation.AND: return leftClass != VoidClassInstance.INSTANCE && leftClass.classId != BoolClassInstance.FALSE &&
                    rightClass != VoidClassInstance.INSTANCE && rightClass.classId != BoolClassInstance.FALSE ?
                    rightClass.createLink(): VoidClassInstance.value;

            case Operation.NULLABLE_OR : if(leftClass== NullClassInstance.INSTANCE)
                return rightLink;
            else return leftLink;

            case Operation.ARRAY_ACCESS: {
                if(leftClass instanceof ArrayClassInstance) {
                    if (rightClass instanceof NumberClassInstance)
                        return new Link(((ArrayClassInstance) leftClass)
                                .get(((NumberClassInstance) rightClass).value.intValue()));
                    else throw new LCLangTypeErrorException("invalid index: excepted int", caller);
                }else throw new LCLangTypeErrorException("excepted array or map", caller);
            }

            case Operation.EQUALS: return new Link(leftClass.equals(rightClass, caller));
            case Operation.NOT_EQUALS: return new Link(BoolClassInstance.not(leftClass.equals(rightClass, caller)));

            default: throw new LCLangTypeErrorException("Operation not supported: "+operation, caller);
        }
    }

    public static class Operation {
        public static final int ARRAY_ACCESS = 1;
        public static final int OR = 2;
        public static final int AND = 3;
        public static final int BINARY_AND = 4;
        public static final int BINARY_XOR = 5;
        public static final int BINARY_LEFT_SHIFT = 6;
        public static final int BINARY_RIGHT_SHIFT = 7;
        public static final int EQUALS = 8;
        public static final int NOT_EQUALS = 9;
        public static final int LESS = 10;
        public static final int LESS_EQUALS = 11;
        public static final int LARGER = 12;
        public static final int LARGER_EQUALS = 13;
        public static final int MULTIPLICATION = 14;
        public static final int DIVISION = 15;
        public static final int ADD = 16;
        public static final int MINUS = 17;
        public static final int POW = 18;
        public static final int NULLABLE_OR = 19;
        public static final int BINARY_OR = 20;
    }
}
