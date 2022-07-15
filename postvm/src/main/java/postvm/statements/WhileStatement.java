package postvm.statements;

import postvm.Caller;
import postvm.Link;
import postvm.PostVMExecutor;
import postvm.exceptions.LCLangRuntimeException;
import postvm.library.classes.BoolClass;
import postvm.library.classes.VoidClass;
import postvm.statements.expressions.Expression;

public class WhileStatement extends Statement {
    public final Expression condition;
    public final Statement body;

    public WhileStatement(Expression condition, Statement body) {
        super(0);
        this.condition = condition;
        this.body = body;
    }

    @Override
    public Link visit(Caller prevCaller, PostVMExecutor visitor) throws LCLangRuntimeException {
        if(body==null) {
            while(condition.visit(prevCaller, visitor).classId != BoolClass.FALSE);
        }else while(condition.visit(prevCaller, visitor).classId != BoolClass.FALSE) {
            Link value = body.visit(prevCaller, visitor);
            if(value.state== Link.State.RETURN)
                return value;
            else if(value.state== Link.State.STOP)
                break;
        }

        return VoidClass.value;
    }
}
