package postvm.statements;

import postvm.Caller;
import postvm.Link;
import postvm.PostVMExecutor;
import postvm.exceptions.LCLangRuntimeException;
import postvm.library.classes.VoidClass;

public class BlockStatement extends Statement {
    public final Statement[] statements;

    public BlockStatement(Statement[] statements) {
        super(0);
        this.statements = statements;
    }

    @Override
    public Link visit(Caller prevCaller, PostVMExecutor visitor) throws LCLangRuntimeException {
        for(Statement stmt: statements) {
            Caller caller = stmt.getCaller(prevCaller);
            Link value = stmt.visit(caller, visitor);
            if (value.state!=Link.State.NOTHING)
                return value;
        }

        return VoidClass.value;
    }
}
