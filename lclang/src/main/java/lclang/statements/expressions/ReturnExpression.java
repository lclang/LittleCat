package lclang.statements.expressions;

import lclang.Caller;
import lclang.LCBaseExecutor;
import lclang.Link;
import lclang.exceptions.LCLangRuntimeException;
import lclang.libs.lang.classes.VoidClass;

public class ReturnExpression extends Expression {
    public final Expression expression;

    public ReturnExpression(Expression expression) {
        super(0);
        this.expression = expression;
    }

    @Override
    public Link visit(Caller prevCaller, LCBaseExecutor visitor) throws LCLangRuntimeException {
        Link value = VoidClass.value;
        if(expression!=null)
            value = expression.visit(prevCaller, visitor);

        value.state = Link.State.RETURN;
        return value;
    }
}
