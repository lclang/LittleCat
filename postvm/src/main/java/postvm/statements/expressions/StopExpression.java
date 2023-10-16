package postvm.statements.expressions;

import postvm.Link;
import postvm.PostVMExecutor;
import postvm.library.classes.VoidClassInstance;

public class StopExpression extends Expression {
    public static final Link STOP_VALUE = new Link(VoidClassInstance.INSTANCE.classId, Link.State.STOP);
    public static final StopExpression STOP = new StopExpression();

    private StopExpression() {
        super(0);
    }

    @Override
    public Link visit(int prevCaller, PostVMExecutor visitor) {
        return STOP_VALUE;
    }
}
