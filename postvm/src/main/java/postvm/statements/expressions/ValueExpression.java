package postvm.statements.expressions;

import postvm.Caller;
import postvm.Link;
import postvm.PostVMExecutor;
import postvm.exceptions.LCLangRuntimeException;
import postvm.library.classes.PostVMClass;

public class ValueExpression extends Expression {
    public final PostVMClass value;

    public ValueExpression(PostVMClass value) {
        super(0);
        this.value = value;
    }

    @Override
    public Link visit(Caller prevCaller, PostVMExecutor visitor) throws LCLangRuntimeException {
        return value.createLink();
    }
}
