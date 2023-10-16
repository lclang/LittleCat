package postvm.statements.expressions;

import postvm.Link;
import postvm.PostVMExecutor;
import postvm.exceptions.LCLangRuntimeException;

public class ReturnExpression extends Expression {
    public final Expression expression;

    public ReturnExpression(Expression expression) {
        super(0);
        this.expression = expression;
    }

    @Override
    public Link visit(int prevCaller, PostVMExecutor visitor) throws LCLangRuntimeException {
        Link value = expression.visit(prevCaller, visitor);
        value.state = Link.State.RETURN;
        return value;
    }
}
