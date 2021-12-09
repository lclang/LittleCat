package lclang.statements.expressions;

import lclang.Caller;
import lclang.LCBaseExecutor;
import lclang.Link;
import lclang.exceptions.LCLangNullPointerException;
import lclang.exceptions.LCLangRuntimeException;
import lclang.exceptions.LCLangTypeErrorException;
import lclang.libs.lang.classes.ArrayClass;
import lclang.libs.lang.classes.BoolClass;
import lclang.libs.lang.classes.LCClass;
import lclang.libs.lang.classes.numbers.IntClass;
import lclang.libs.lang.classes.numbers.NumberClass;

public class UnaryOperationExpression extends Expression {
    public final Expression expression;
    public final Operation operation;

    public UnaryOperationExpression(Expression expression, Operation operation, int line) {
        super(line);
        this.expression = expression;
        this.operation = operation;
    }

    @Override
    public Link visit(Caller prevCaller, LCBaseExecutor visitor) throws LCLangRuntimeException {
        Caller caller = getCaller(prevCaller);
        Link leftValue = expression.visit(caller, visitor);
        LCClass left = leftValue.get.invoke(caller);

        LCClass clazz;
        switch (operation){
            case ARRAY_ACCESS:
                if(left instanceof ArrayClass) {
                    ArrayClass array = (ArrayClass) left;
                    Link value = array.last().createLink();
                    value.set = (caller1, clazz1) -> array.add(clazz1);

                    return value;
                }else throw new LCLangTypeErrorException("Value is not array", caller);

            case NOT:
                return BoolClass.get(left instanceof BoolClass &&!((BoolClass) left).bool).createLink();

            case NULL_CHECK:
                if(left==null)
                    throw new LCLangNullPointerException(caller);
                else clazz = leftValue.get.invoke(caller);
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

        leftValue.set.invoke(caller, clazz);
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
