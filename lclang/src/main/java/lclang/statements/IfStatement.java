package lclang.statements;

import lclang.Caller;
import lclang.LCBaseExecutor;
import lclang.LCClass;
import lclang.Value;
import lclang.exceptions.LCLangException;
import lclang.libs.lang.BoolClass;
import lclang.statements.expressions.Expression;

public class IfStatement extends Statement {
    public final Expression condition;
    public final Statement ifTrue;
    public final Statement ifFalse;

    public IfStatement(Expression condition, Statement ifTrue, Statement ifFalse) {
        super(0, 0);
        this.condition = condition;
        this.ifTrue = ifTrue;
        this.ifFalse = ifFalse;
    }

    @Override
    public Value visit(Caller prevCaller, LCBaseExecutor visitor) throws LCLangException {
        LCClass cond = condition.visit(prevCaller, visitor).get.invoke(prevCaller);
        if(!cond.equals(BoolClass.FALSE)) {
            return ifTrue.visit(prevCaller, visitor);
        }

        if(ifFalse!=null){
            return ifFalse.visit(prevCaller, visitor);
        }

        return Value.VOID;
    }
}