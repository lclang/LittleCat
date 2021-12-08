package lclang.statements;

import lclang.Caller;
import lclang.LCBaseExecutor;
import lclang.Link;
import lclang.exceptions.LCLangRuntimeException;
import lclang.libs.lang.classes.BoolClass;
import lclang.libs.lang.classes.LCClass;
import lclang.libs.lang.classes.VoidClass;
import lclang.statements.expressions.Expression;

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
    public Link visit(Caller prevCaller, LCBaseExecutor visitor) throws LCLangRuntimeException {
        LCClass cond = condition.visit(prevCaller, visitor).get.invoke(prevCaller);
        if(cond!=BoolClass.FALSE) {
            return ifTrue.visit(prevCaller, visitor);
        }

        if(ifFalse!=null){
            return ifFalse.visit(prevCaller, visitor);
        }

        return VoidClass.value;
    }
}
