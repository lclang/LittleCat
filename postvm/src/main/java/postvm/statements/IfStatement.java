package postvm.statements;

import postvm.Caller;
import postvm.Link;
import postvm.PostVMExecutor;
import postvm.exceptions.LCLangRuntimeException;
import postvm.library.classes.BoolClass;
import postvm.library.classes.PostVMClass;
import postvm.library.classes.VoidClass;
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
    public Link visit(Caller prevCaller, PostVMExecutor visitor) throws LCLangRuntimeException {
        PostVMClass cond = condition.visit(prevCaller, visitor).get(prevCaller);
        if(cond!=BoolClass.FALSE) {
            return ifTrue.visit(prevCaller, visitor);
        }else if(ifFalse!=null){
            return ifFalse.visit(prevCaller, visitor);
        }else return VoidClass.value;
    }
}
