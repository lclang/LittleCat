package lclang.statements;

import lclang.Caller;
import lclang.LCBaseExecutor;
import lclang.Value;
import lclang.exceptions.LCLangException;
import lclang.libs.lang.BoolClass;
import lclang.statements.expressions.Expression;

public class WhileStatement extends Statement {
    public final Expression condition;
    public final Statement body;

    public WhileStatement(Expression condition, Statement body) {
        super(0, 0);
        this.condition = condition;
        this.body = body;
    }

    @Override
    public Value visit(Caller prevCaller, LCBaseExecutor visitor) throws LCLangException {
        if(body==null) {
            while(true) {
                if(condition.visit(prevCaller, visitor).get.invoke(prevCaller)
                        .equals(BoolClass.FALSE)) break;
            }
        }else while(true) {
            if(condition.visit(prevCaller, visitor).get.invoke(prevCaller)
                    .equals(BoolClass.FALSE)) break;

            Value value = body.visit(prevCaller, visitor);
            if(value.state==Value.State.RETURN)
                return value;
            else if(value.state==Value.State.STOP)
                break;
        }

        return Value.VOID;
    }
}
