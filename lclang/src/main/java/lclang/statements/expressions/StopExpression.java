package lclang.statements.expressions;

import lclang.Caller;
import lclang.LCBaseExecutor;
import lclang.Value;
import lclang.types.Types;

public class StopExpression extends Expression {
    public StopExpression(int line, int column) {
        super(line, column);
    }

    @Override
    public Value visit(Caller prevCaller, LCBaseExecutor visitor) {
        return new Value(Types.VOID, Value.State.STOP);
    }
}
