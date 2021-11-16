package lclang.statements.expressions;

import lclang.Caller;
import lclang.LCBaseExecutor;
import lclang.Value;
import lclang.exceptions.LCLangException;

public class ReturnExpression extends Expression {
    public final Expression expression;

    public ReturnExpression(Expression expression) {
        super(0, 0);
        this.expression = expression;
    }

    @Override
    public Value visit(Caller prevCaller, LCBaseExecutor visitor) throws LCLangException {
        Value value = Value.VOID;
        if(expression!=null)
            value = expression.visit(prevCaller, visitor);

        value.state = Value.State.RETURN;
        return value;
    }
}