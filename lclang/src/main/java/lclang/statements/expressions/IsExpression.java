package lclang.statements.expressions;

import lclang.Caller;
import lclang.LCBaseExecutor;
import lclang.Link;
import lclang.exceptions.LCLangRuntimeException;
import lclang.libs.lang.classes.BoolClass;
import lclang.statements.TypeStatement;

public class IsExpression extends Expression {
    public final Expression checkExpression;
    public final TypeStatement type;
    public IsExpression(Expression checkExpression, TypeStatement type) {
        super(0);
        this.checkExpression = checkExpression;
        this.type = type;
    }

    @Override
    public Link visit(Caller prevCaller, LCBaseExecutor visitor) throws LCLangRuntimeException {
        return BoolClass.get(type
                .toType(visitor.root)
                .isAccept(checkExpression.visit(prevCaller, visitor).type)).createLink();
    }
}
