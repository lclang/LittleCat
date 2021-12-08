package lclang.statements;

import lclang.Caller;
import lclang.LCBaseExecutor;
import lclang.Link;
import lclang.exceptions.LCLangRuntimeException;
import lclang.libs.lang.classes.BoolClass;
import lclang.libs.lang.classes.VoidClass;
import lclang.statements.expressions.Expression;

public class WhileStatement extends Statement {
    public final Expression condition;
    public final Statement body;

    public WhileStatement(Expression condition, Statement body) {
        super(0);
        this.condition = condition;
        this.body = body;
    }

    @Override
    public Link visit(Caller prevCaller, LCBaseExecutor visitor) throws LCLangRuntimeException {
        if(body==null) {
            while(condition.visit(prevCaller, visitor).get.invoke(prevCaller) != BoolClass.FALSE);
        }else while(condition.visit(prevCaller, visitor).get.invoke(prevCaller) != BoolClass.FALSE) {
            Link value = body.visit(prevCaller, visitor);
            if(value.state== Link.State.RETURN)
                return value;
            else if(value.state== Link.State.STOP)
                break;
        }

        return VoidClass.value;
    }
}
