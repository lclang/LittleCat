package lclang.statements;

import lclang.Caller;
import lclang.LCBaseExecutor;
import lclang.LCRootExecutor;
import lclang.Link;
import lclang.exceptions.LCLangRuntimeException;

public abstract class Statement {
    public final int line;

    public Statement(int line) {
        this.line = line;
    }

    public abstract Link visit(Caller prevCaller, LCBaseExecutor visitor) throws LCLangRuntimeException;

    public Caller getCaller(Caller caller) {
        return new Caller(caller.root, line, caller);
    }
    public Caller getCaller(LCRootExecutor root) {
        return new Caller(root, line, null);
    }
}
