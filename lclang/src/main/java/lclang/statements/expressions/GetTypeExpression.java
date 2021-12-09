package lclang.statements.expressions;

import lclang.Caller;
import lclang.LCBaseExecutor;
import lclang.Link;
import lclang.exceptions.LCLangRuntimeException;
import lclang.libs.lang.classes.StringClass;

public class GetTypeExpression extends Expression {
    public final Expression expression;

    public GetTypeExpression(Expression expression) {
        super(0);
        this.expression = expression;
    }

    @Override
    public Link visit(Caller prevCaller, LCBaseExecutor visitor) throws LCLangRuntimeException {
        return StringClass.get(expression.visit(prevCaller, visitor).get
                .invoke(prevCaller).classType.text).createLink();
    }
}
