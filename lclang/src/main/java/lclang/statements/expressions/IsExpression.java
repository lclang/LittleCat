package lclang.statements.expressions;

import lclang.Caller;
import lclang.LCBaseExecutor;
import lclang.Value;
import lclang.exceptions.LCLangException;
import lclang.libs.lang.BoolClass;
import lclang.statements.TypeStatement;

public class IsExpression extends Expression {
    public final Expression checkExpression;
    public final TypeStatement type;
    public IsExpression(Expression checkExpression, TypeStatement type) {
        super(0, 0);
        this.checkExpression = checkExpression;
        this.type = type;
    }

    @Override
    public Value visit(Caller prevCaller, LCBaseExecutor visitor) throws LCLangException {
        return new BoolClass(type
                .toType(visitor.root)
                .isAccept(checkExpression.visit(prevCaller, visitor).type)).asValue();
    }
}
