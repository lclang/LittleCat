package lclang.statements.expressions;

import lclang.Caller;
import lclang.LCBaseExecutor;
import lclang.Value;
import lclang.exceptions.LCLangRuntimeException;
import lclang.statements.Statement;

public class ContainerExpression extends Expression {
    private final Statement[] statements;

    public ContainerExpression(Statement[] statements) {
        super(0);
        this.statements = statements;
    }

    @Override
    public Value visit(Caller prevCaller, LCBaseExecutor visitor) throws LCLangRuntimeException {
        for(Statement stmt: statements) {
            Caller caller = stmt.getCaller(prevCaller);
            Value value = stmt.visit(caller, visitor);
            if(value.state!= Value.State.NOTHING) {
                if(value.state== Value.State.RETURN)
                    value.state = Value.State.NOTHING;

                return value;
            }else value.get.invoke(caller);
        }

        return Value.VOID;
    }
}
