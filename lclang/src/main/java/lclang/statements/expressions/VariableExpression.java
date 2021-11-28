package lclang.statements.expressions;

import lclang.Caller;
import lclang.LCBaseExecutor;
import lclang.Value;
import lclang.exceptions.LCLangRuntimeException;
import org.jetbrains.annotations.NotNull;

public class VariableExpression extends Expression {
    public final String name;

    public VariableExpression(String name, int line) {
        super(line);
        this.name = name;
    }

    @NotNull
    @Override
    public Value visit(Caller prevCaller, LCBaseExecutor visitor) throws LCLangRuntimeException {
        return visitor.getLink(getCaller(prevCaller), name);
    }
}
