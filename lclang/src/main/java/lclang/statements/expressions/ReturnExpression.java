package lclang.statements.expressions;

import lclang.Caller;
import lclang.LCBaseExecutor;
import lclang.Value;
import lclang.exceptions.LCLangException;

public class ReturnExpression extends Expression {
    public final Expression expression;

    public ReturnExpression(Expression expression, int line, int column) {
        super(line, column);
        this.expression = expression;
    }

    @Override
    public Value visit(Caller prevCaller, LCBaseExecutor visitor) throws LCLangException {
        Caller caller = getCaller(prevCaller);
        Value value = Value.VOID;
        if(expression!=null)
            value = expression.visit(caller, visitor);

        value.state = Value.State.RETURN;
        return value;
    }
}
