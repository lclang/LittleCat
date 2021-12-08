package lclang.statements;

import lclang.Caller;
import lclang.LCBaseExecutor;
import lclang.Link;
import lclang.exceptions.LCLangRuntimeException;
import lclang.libs.lang.classes.VoidClass;

public class BlockStatement extends Statement {
    public final Statement[] statements;

    public BlockStatement(Statement[] statements) {
        super(0);
        this.statements = statements;
    }

    @Override
    public Link visit(Caller prevCaller, LCBaseExecutor visitor) throws LCLangRuntimeException {
        for(Statement stmt: statements) {
            Caller caller = stmt.getCaller(prevCaller);
            Link value = stmt.visit(caller, visitor);
            if (value.state!= Link.State.NOTHING)
                return value;
            else value.get.invoke(caller);
        }

        return VoidClass.value;
    }
}
