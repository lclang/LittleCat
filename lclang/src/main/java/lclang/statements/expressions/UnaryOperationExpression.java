package lclang.statements.expressions;

import lclang.Caller;
import lclang.LCBaseExecutor;
import lclang.LCClass;
import lclang.Value;
import lclang.exceptions.LCLangNullPointerException;
import lclang.exceptions.LCLangRuntimeException;
import lclang.exceptions.LCLangTypeErrorException;
import lclang.libs.lang.classes.BoolClass;
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
    public Value visit(Caller prevCaller, LCBaseExecutor visitor) throws LCLangRuntimeException {
        Caller caller = getCaller(prevCaller);
        Value leftValue = expression.visit(caller, visitor);
        LCClass left = leftValue.get.invoke(caller);

        Value value;
        switch (operation){
            case NOT:
                value = BoolClass.get(left instanceof BoolClass &&!((BoolClass) left).bool).asValue();
                break;

            case NULL_CHECK:
                if(left==null)
                    throw new LCLangNullPointerException(caller);
                else value = leftValue;
                break;

            case UNARY_PLUS:
                if(left instanceof NumberClass){
                    value = ((NumberClass) left).add(IntClass.get(1)).asValue();
                    break;
                }

            case UNARY_MINUS:
                if(left instanceof NumberClass){
                    value = ((NumberClass) left).minus(IntClass.get(1)).asValue();
                    break;
                }

            default: throw new LCLangTypeErrorException("Operation not supported", caller);
        }

        leftValue.set.invoke(caller, value);
        return value;
    }

    public enum Operation {
        NULL_CHECK,
        UNARY_PLUS,
        UNARY_MINUS,
        NOT,
    }
}
