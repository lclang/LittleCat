package lclang.statements.expressions;

import lclang.Caller;
import lclang.LCBaseExecutor;
import lclang.Value;
import lclang.types.Types;

public class StopExpression extends Expression {
    public static final Value STOP_VALUE = new Value(Types.VOID, Value.State.STOP);

    public StopExpression(int line) {
        super(line);
    }

    @Override
    public Value visit(Caller prevCaller, LCBaseExecutor visitor) {
        return STOP_VALUE;
    }
}
