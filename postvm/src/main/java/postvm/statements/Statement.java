package postvm.statements;

import postvm.Caller;
import postvm.Link;
import postvm.PostVMExecutor;
import postvm.exceptions.LCLangRuntimeException;

public abstract class Statement {
    public final int line;

    public Statement(int line) {
        this.line = line;
    }

    public abstract Link visit(Caller prevCaller, PostVMExecutor visitor) throws LCLangRuntimeException;

    public Caller getCaller(Caller caller) {
        return new Caller(caller.root, line, caller);
    }
}
