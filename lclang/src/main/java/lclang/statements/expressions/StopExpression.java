package lclang.statements.expressions;

import lclang.Caller;
import lclang.LCBaseExecutor;
import lclang.Link;
import lclang.libs.lang.classes.VoidClass;

public class StopExpression extends Expression {
    public static final Link STOP_VALUE = new Link(VoidClass.instance, Link.State.STOP);

    public StopExpression(int line) {
        super(line);
    }

    @Override
    public Link visit(Caller prevCaller, LCBaseExecutor visitor) {
        return STOP_VALUE;
    }
}
