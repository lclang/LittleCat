package lclang.statements.expressions;

import lclang.Caller;
import lclang.LCBaseExecutor;
import lclang.Value;
import lclang.exceptions.LCLangRuntimeException;
import org.jetbrains.annotations.NotNull;

public class AssignExpression extends Expression {
    public final Expression left;
    public final Expression right;

    public AssignExpression(Expression left, Expression right) {
        super(0);
        this.left = left;
        this.right = right;
    }

    @NotNull
    @Override
    public Value visit(Caller prevCaller, LCBaseExecutor visitor) throws LCLangRuntimeException {
        Value settableValue = left.visit(prevCaller, visitor);
        Value value = right.visit(prevCaller, visitor);

        settableValue.set.invoke(prevCaller, value);
        return value;
    }
}
