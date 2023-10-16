package postvm.statements;

import postvm.Link;
import postvm.PostVMExecutor;
import postvm.exceptions.LCLangRuntimeException;
import postvm.library.classes.BoolClassInstance;
import postvm.library.classes.VoidClassInstance;
import postvm.statements.expressions.Expression;

public class IfStatement extends Statement {
    public final Expression condition;
    public final Statement ifTrue;
    public final Statement ifFalse;

    public IfStatement(Expression condition, Statement ifTrue, Statement ifFalse) {
        super(0);
        this.condition = condition;
        this.ifTrue = ifTrue;
        this.ifFalse = ifFalse;
    }

    @Override
    public Link visit(int prevCaller, PostVMExecutor visitor) throws LCLangRuntimeException {
        int cond = condition.visit(prevCaller, visitor).classId;
        if(cond!= BoolClassInstance.FALSE) {
            return ifTrue.visit(prevCaller, visitor);
        }else if(ifFalse!=null){
            return ifFalse.visit(prevCaller, visitor);
        }

        return VoidClassInstance.value;
    }
}
