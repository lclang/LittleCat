package postvm.statements.expressions;

import postvm.Caller;
import postvm.Link;
import postvm.PostVMExecutor;
import postvm.exceptions.LCLangNullPointerException;
import postvm.exceptions.LCLangRuntimeException;
import postvm.exceptions.LCLangTypeErrorException;
import postvm.library.classes.ArrayClass;
import postvm.library.classes.BoolClass;
import postvm.library.classes.PostVMClass;
import postvm.library.classes.numbers.IntClass;
import postvm.library.classes.numbers.NumberClass;

public class UnaryOperationExpression extends Expression {
    public final Expression expression;
    public final Operation operation;

    public UnaryOperationExpression(Expression expression, Operation operation, int line) {
        super(line);
        this.expression = expression;
        this.operation = operation;
    }

    @Override
    public Link visit(Caller prevCaller, PostVMExecutor visitor) throws LCLangRuntimeException {
        Caller caller = getCaller(prevCaller);
        Link leftValue = expression.visit(caller, visitor);
        PostVMClass left = leftValue.get(caller);

        PostVMClass clazz;
        switch (operation){
            case ARRAY_ACCESS:
                if(left instanceof ArrayClass) {
                    ArrayClass array = (ArrayClass) left;
                    return new Link(Link.State.NOTHING) {
                        @Override
                        public PostVMClass get(Caller caller) throws LCLangRuntimeException {
                            return array.last();
                        }

                        @Override
                        public void set(Caller caller, PostVMClass value) throws LCLangRuntimeException {
                            array.add(value);
                        }
                    };
                }else throw new LCLangTypeErrorException("Value is not array", caller);

            case NOT:
                return BoolClass.get(left instanceof BoolClass &&!((BoolClass) left).bool).createLink();

            case NULL_CHECK:
                if(left==null)
                    throw new LCLangNullPointerException(caller);
                else clazz = leftValue.get(caller);
                break;

            case UNARY_PLUS:
                if(left instanceof NumberClass){
                    clazz = ((NumberClass) left).add(IntClass.get(1));
                    break;
                }

            case UNARY_MINUS:
                if(left instanceof NumberClass){
                    clazz = ((NumberClass) left).minus(IntClass.get(1));
                    break;
                }

            default: throw new LCLangTypeErrorException("Operation not supported", caller);
        }

        leftValue.set(caller, clazz);
        return clazz.createLink();
    }

    public enum Operation {
        NULL_CHECK,
        UNARY_PLUS,
        UNARY_MINUS,
        NOT,
        ARRAY_ACCESS
    }
}
