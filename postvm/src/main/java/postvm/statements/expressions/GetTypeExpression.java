package postvm.statements.expressions;

import postvm.Caller;
import postvm.Link;
import postvm.PostVMExecutor;
import postvm.exceptions.LCLangRuntimeException;
import postvm.library.classes.StringClass;

public class GetTypeExpression extends Expression {
    public final Expression expression;

    public GetTypeExpression(Expression expression) {
        super(0);
        this.expression = expression;
    }

    @Override
    public Link visit(Caller prevCaller, PostVMExecutor visitor) throws LCLangRuntimeException {
        return StringClass.get(expression.visit(prevCaller, visitor).get(prevCaller)
                .classType.toString()).createLink();
    }
}
