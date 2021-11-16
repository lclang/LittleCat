package lclang.statements.expressions;

import lclang.Caller;
import lclang.LCBaseExecutor;
import lclang.Value;
import lclang.exceptions.LCLangException;
import lclang.statements.Statement;

public class ContainerExpression extends Expression {
    private final Statement[] statements;

    public ContainerExpression(Statement[] statements) {
        super(0, 0);
        this.statements = statements;
    }

    @Override
    public Value visit(Caller prevCaller, LCBaseExecutor visitor) throws LCLangException {
        for(Statement stmt: statements) {
            Value value = stmt.visit(prevCaller, visitor);
            if(value.state!= Value.State.NOTHING) {
                if(value.state== Value.State.RETURN)
                    value.state = Value.State.NOTHING;

                return value;
            }else value.get.invoke(prevCaller);
        }

        return Value.VOID;
    }
}
