package lclang.statements.expressions;

import lclang.Caller;
import lclang.LCBaseExecutor;
import lclang.Value;
import lclang.exceptions.LCLangException;

public class VariableExpression extends Expression {
    public final String name;

    public VariableExpression(String name, int line, int column) {
        super(line, column);
        this.name = name;
    }

    @Override
    public Value visit(Caller prevCaller, LCBaseExecutor visitor) throws LCLangException {
        return visitor.getLink(name);
    }
}
