package lclang.statements.expressions;

import lclang.Caller;
import lclang.LCBaseExecutor;
import lclang.Value;
import lclang.exceptions.LCLangException;
import lclang.statements.Statement;

public class ContainerExpression extends Expression {
    private final Statement[] statements;

    public ContainerExpression(Statement[] statements, int line, int column) {
        super(line, column);
        this.statements = statements;
    }

    @Override
    public Value visit(Caller prevCaller, LCBaseExecutor visitor) throws LCLangException {
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
