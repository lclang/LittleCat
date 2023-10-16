package postvm.statements;

import postvm.Link;
import postvm.PostVMExecutor;
import postvm.exceptions.LCLangRuntimeException;
import postvm.library.classes.VoidClassInstance;

public class BlockStatement extends Statement {
    public final Statement[] statements;

    public BlockStatement(Statement[] statements) {
        super(0);
        this.statements = statements;
    }

    @Override
    public Link visit(int prevCaller, PostVMExecutor visitor) throws LCLangRuntimeException {
        for(Statement stmt: statements) {
            int caller = stmt.getCaller(prevCaller);

            Link value = stmt.visit(caller, visitor);
            if (value.state!=Link.State.NOTHING)
                return value;
        }

        return VoidClassInstance.value;
    }
}
