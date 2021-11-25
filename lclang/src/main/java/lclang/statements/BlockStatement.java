package lclang.statements;

import lclang.Caller;
import lclang.LCBaseExecutor;
import lclang.Value;
import lclang.exceptions.LCLangException;

public class BlockStatement extends Statement {
    public final Statement[] statements;

    public BlockStatement(Statement[] statements) {
        super(0);
        this.statements = statements;
    }

    @Override
    public Value visit(Caller prevCaller, LCBaseExecutor visitor) throws LCLangException {
        for(Statement stmt: statements) {
            Caller caller = stmt.getCaller(prevCaller);
            Value value = stmt.visit(caller, visitor);
            if (value.state!= Value.State.NOTHING)
                return value;
            else value.get.invoke(caller);
        }

        return Value.VOID;
    }
}
