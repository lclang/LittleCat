package lclang.statements.expressions;

import lclang.Caller;
import lclang.LCBaseExecutor;
import lclang.Value;
import lclang.exceptions.LCLangRuntimeException;

public class ValueExpression extends Expression {
    public final Value value;

    public ValueExpression(Value value) {
        super(0);
        this.value = value;
    }

    @Override
    public Value visit(Caller prevCaller, LCBaseExecutor visitor) throws LCLangRuntimeException {
        return value;
    }
}
