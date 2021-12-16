package postvm.statements;

import postvm.Caller;
import postvm.Link;
import postvm.PostVMExecutor;
import postvm.PostVMRoot;
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
    public Caller getCaller(PostVMRoot root) {
        return new Caller(root, line, null);
    }
}
