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

    public IfStatement(Expression condition, Statement ifTrue, Statement ifFalse, int line, int column) {
        super(line, column);
        this.condition = condition;
        this.ifTrue = ifTrue;
        this.ifFalse = ifFalse;
    }

    @Override
    public Value visit(Caller prevCaller, LCBaseExecutor visitor) throws LCLangException {
        Caller caller = getCaller(prevCaller);
        LCClass cond = condition.visit(caller, visitor).get.invoke(caller);
        if(!cond.equals(BoolClass.FALSE)) {
            return ifTrue.visit(caller, visitor);
        }

        if(ifFalse!=null){
            return ifFalse.visit(caller, visitor);
        }

        return Value.VOID;
    }
}
