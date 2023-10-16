package postvm.statements.expressions;

import postvm.Link;
import postvm.PostVMExecutor;
import postvm.exceptions.LCLangNullPointerException;
import postvm.exceptions.LCLangRuntimeException;
import postvm.exceptions.LCLangTypeErrorException;
import postvm.library.classes.ArrayClassInstance;
import postvm.library.classes.BoolClassInstance;
import postvm.library.classes.NullClassInstance;
import postvm.classes.PostVMClassInstance;
import postvm.library.classes.NumberClassInstance;

public class UnaryOperationExpression extends Expression {
    public final Expression expression;
    public final int operation;

    public UnaryOperationExpression(Expression expression, int operation, int line) {
        super(line);
        this.expression = expression;
        this.operation = operation;
    }

    @Override
    public Link visit(int prevCaller, PostVMExecutor visitor) throws LCLangRuntimeException {
        int caller = getCaller(prevCaller);
        Link leftValue = expression.visit(caller, visitor);
        if(leftValue.state != Link.State.NOTHING) return leftValue;

        int clazz;
        switch (operation){
            case Operation.ARRAY_ACCESS: {
                PostVMClassInstance left = leftValue.get();
                if (left instanceof ArrayClassInstance) {
                    ArrayClassInstance array = (ArrayClassInstance) left;
                    return new Link(array.last(), Link.State.NOTHING) {

                        @Override
                        public void set(int caller, int value) throws LCLangRuntimeException {
                            array.add(value);
                        }
                    };
                } else throw new LCLangTypeErrorException("Value is not array", caller);
            }

            case Operation.NOT:
                return new Link(
                        leftValue.classId == BoolClassInstance.FALSE ?
                                BoolClassInstance.TRUE : BoolClassInstance.FALSE
                );

            case Operation.NULL_CHECK:
                if(leftValue.classId== NullClassInstance.INSTANCE.classId)
                    throw new LCLangNullPointerException(caller);
                else clazz = leftValue.classId;

                break;

            case Operation.UNARY_PLUS: {
                PostVMClassInstance left = leftValue.get();
                if (left instanceof NumberClassInstance) {
                    clazz = left.cast(NumberClassInstance.class).add(PostVMClassInstance.instances.get(NumberClassInstance.get(1)).cast(NumberClassInstance.class));
                    break;
                }
            }

            case Operation.UNARY_MINUS: {
                PostVMClassInstance left = leftValue.get();
                if (left instanceof NumberClassInstance) {
                    clazz = left.cast(NumberClassInstance.class).minus(PostVMClassInstance.instances.get(NumberClassInstance.get(1)).cast(NumberClassInstance.class));
                    break;
                }
            }

            case Operation.BINARY_COMPLIMENT: {
                PostVMClassInstance left = leftValue.get();
                if (left instanceof NumberClassInstance) {
                    return new Link(left.cast(NumberClassInstance.class).compliment());
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
