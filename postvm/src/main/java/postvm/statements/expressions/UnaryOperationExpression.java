package postvm.statements.expressions;

import postvm.Caller;
import postvm.Link;
import postvm.PostVMExecutor;
import postvm.exceptions.LCLangNullPointerException;
import postvm.exceptions.LCLangRuntimeException;
import postvm.exceptions.LCLangTypeErrorException;
import postvm.library.classes.ArrayClass;
import postvm.library.classes.BoolClass;
import postvm.library.classes.NullClass;
import postvm.library.classes.PostVMClass;
import postvm.library.classes.numbers.NumberClass;

public class UnaryOperationExpression extends Expression {
    public final Expression expression;
    public final int operation;

    public UnaryOperationExpression(Expression expression, int operation, int line) {
        super(line);
        this.expression = expression;
        this.operation = operation;
    }

    @Override
    public Link visit(Caller prevCaller, PostVMExecutor visitor) throws LCLangRuntimeException {
        Caller caller = getCaller(prevCaller);
        Link leftValue = expression.visit(caller, visitor);
        if(leftValue.state != Link.State.NOTHING) return leftValue;

        int clazz;
        switch (operation){
            case Operation.ARRAY_ACCESS: {
                PostVMClass left = leftValue.get();
                if (left instanceof ArrayClass) {
                    ArrayClass array = (ArrayClass) left;
                    return new Link(array.last(), Link.State.NOTHING) {

                        @Override
                        public void set(Caller caller, int value) throws LCLangRuntimeException {
                            array.add(value);
                        }
                    };
                } else throw new LCLangTypeErrorException("Value is not array", caller);
            }

            case Operation.NOT:
                return new Link(
                        leftValue.classId == BoolClass.FALSE ?
                                BoolClass.TRUE : BoolClass.FALSE
                );

            case Operation.NULL_CHECK:
                if(leftValue.classId==NullClass.INSTANCE.classId)
                    throw new LCLangNullPointerException(caller);
                else clazz = leftValue.classId;

                break;

            case Operation.UNARY_PLUS: {
                PostVMClass left = leftValue.get();
                if (left instanceof NumberClass) {
                    clazz = left.cast(NumberClass.class).add(PostVMClass.instances.get(NumberClass.get(1)).cast(NumberClass.class));
                    break;
                }
            }

            case Operation.UNARY_MINUS: {
                PostVMClass left = leftValue.get();
                if (left instanceof NumberClass) {
                    clazz = left.cast(NumberClass.class).minus(PostVMClass.instances.get(NumberClass.get(1)).cast(NumberClass.class));
                    break;
                }
            }

            case Operation.BINARY_COMPLIMENT: {
                PostVMClass left = leftValue.get();
                if (left instanceof NumberClass) {
                    return new Link(left.cast(NumberClass.class).compliment());
                }
            }

            default: throw new LCLangTypeErrorException("Operation not supported", caller);
        }

        leftValue.set(caller, clazz);
        return new Link(clazz);
    }

    public static class Operation {
        public static final int NULL_CHECK = 1;
        public static final int UNARY_PLUS = 2;
        public static final int UNARY_MINUS = 3;
        public static final int NOT = 4;
        public static final int ARRAY_ACCESS = 5;
        public static final int BINARY_COMPLIMENT = 6;
    }
}
