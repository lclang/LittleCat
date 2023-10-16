package postvm.statements.expressions;

import postvm.Link;
import postvm.PostVMExecutor;
import postvm.exceptions.LCLangRuntimeException;
import postvm.library.classes.BoolClassInstance;

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
    public Link visit(int prevCaller, PostVMExecutor visitor) throws LCLangRuntimeException {
        if(condition.visit(prevCaller, visitor).classId!= BoolClassInstance.FALSE){
            return ifTrue.visit(prevCaller, visitor);
        }

        return ifFalse.visit(prevCaller, visitor);
    }
}
