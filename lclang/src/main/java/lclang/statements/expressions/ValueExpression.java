package lclang.statements.expressions;

import lclang.Caller;
import lclang.LCBaseExecutor;
import lclang.Value;
import lclang.exceptions.LCLangException;

public class ValueExpression extends Expression {
    public final Value value;

    public ValueExpression(Value value, int line, int column) {
        super(line, column);
        this.value = value;
    }

    @Override
    public Value visit(Caller prevCaller, LCBaseExecutor visitor) throws LCLangException {
        return value;
    }
}
