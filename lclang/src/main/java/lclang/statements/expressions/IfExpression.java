package lclang.statements.expressions;

import lclang.Caller;
import lclang.LCBaseExecutor;
import lclang.LCClass;
import lclang.Value;
import lclang.exceptions.LCLangException;
import lclang.libs.lang.classes.BoolClass;

public class IfExpression extends Expression {
    public final Expression condition;
    public final Expression ifTrue;
    public final Expression ifFalse;

    public IfExpression(Expression condition, Expression ifTrue, Expression ifFalse) {
        super(0);
        this.condition = condition;
        this.ifTrue = ifTrue;
        this.ifFalse = ifFalse;
    }

    @Override
    public Value visit(Caller prevCaller, LCBaseExecutor visitor) throws LCLangException {
        LCClass cond = condition.visit(prevCaller, visitor).get.invoke(prevCaller);
        if(!cond.equals(BoolClass.FALSE)){
            return ifTrue.visit(prevCaller, visitor);
        }

        return ifFalse.visit(prevCaller, visitor);
    }
}
