package lclang.statements.expressions;

import lclang.Caller;
import lclang.LCBaseExecutor;
import lclang.Value;
import lclang.libs.lang.classes.NullClass;
import lclang.libs.lang.classes.VoidClass;

public class StopExpression extends Expression {
    public static final Value STOP_VALUE = new Value(VoidClass.type, NullClass.instance, Value.State.STOP);

    public StopExpression(int line) {
        super(line);
    }

    @Override
    public Value visit(Caller prevCaller, LCBaseExecutor visitor) {
        return STOP_VALUE;
    }
}
