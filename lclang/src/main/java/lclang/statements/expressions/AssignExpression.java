package lclang.statements.expressions;

import lclang.Caller;
import lclang.LCBaseExecutor;
import lclang.Value;
import lclang.exceptions.LCLangException;

public class AssignExpression extends Expression {
    public final Expression left;
    public final Expression right;

    public AssignExpression(Expression left, Expression right) {
        super(0, 0);
        this.left = left;
        this.right = right;
    }

    @Override
    public Value visit(Caller prevCaller, LCBaseExecutor visitor) throws LCLangException {
        Caller caller = getCaller(prevCaller);
        Value settableValue = left.visit(caller, visitor);
        Value value = right.visit(caller, visitor);

        settableValue.set.invoke(caller, value);
        return value;
    }
}
