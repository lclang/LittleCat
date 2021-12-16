package postvm.statements.expressions;

import postvm.Caller;
import postvm.Link;
import postvm.PostVMExecutor;
import postvm.exceptions.LCLangRuntimeException;
import postvm.library.classes.PostVMClass;
import postvm.library.classes.VoidClass;

public class StopExpression extends Expression {
    public static final Link STOP_VALUE = new Link(Link.State.RETURN) {
        @Override
        public PostVMClass get(Caller caller) throws LCLangRuntimeException {
            return VoidClass.instance;
        }
    };

    public StopExpression(int line) {
        super(line);
    }

    @Override
    public Link visit(Caller prevCaller, PostVMExecutor visitor) {
        return STOP_VALUE;
    }
}
