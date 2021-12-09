package lclang.statements.expressions;

import lclang.Caller;
import lclang.LCBaseExecutor;
import lclang.Link;
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
    public Link visit(Caller prevCaller, LCBaseExecutor visitor) throws LCLangRuntimeException {
        Link value = right.visit(prevCaller, visitor);
        left.visit(prevCaller, visitor).set.invoke(prevCaller, value.get.invoke(prevCaller));
        return value;
    }
}
