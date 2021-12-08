package lclang.statements.expressions;

import lclang.Caller;
import lclang.LCBaseExecutor;
import lclang.Value;
import lclang.exceptions.LCLangRuntimeException;

public class AssignExpression extends Expression {
    public final Expression left;
    public final Expression right;

    public AssignExpression(Expression left, Expression right) {
        super(0);
        this.left = left;
        this.right = right;
    }

    @Override
    public Value visit(Caller prevCaller, LCBaseExecutor visitor) throws LCLangRuntimeException {
        Value settableValue = left.visit(prevCaller, visitor);
        Value value = right.visit(prevCaller, visitor);
        settableValue.set.invoke(prevCaller, value.get.invoke(prevCaller));
        return value;
    }
}
