package postvm.statements;

import postvm.Link;
import postvm.PostVMExecutor;
import postvm.exceptions.LCLangRuntimeException;
import postvm.library.classes.BoolClassInstance;
import postvm.library.classes.VoidClassInstance;
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
    public Link visit(int prevCaller, PostVMExecutor visitor) throws LCLangRuntimeException {
        if(body==null) {
            while(condition.visit(prevCaller, visitor).classId != BoolClassInstance.FALSE);
        }else while(condition.visit(prevCaller, visitor).classId != BoolClassInstance.FALSE) {
            Link value = body.visit(prevCaller, visitor);
            if(value.state==Link.State.RETURN)
                return value;
            else if(value.state==Link.State.STOP)
                break;
        }

        return VoidClassInstance.value;
    }
}
