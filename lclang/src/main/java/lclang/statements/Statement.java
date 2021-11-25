package lclang.statements;

import lclang.Caller;
import lclang.LCBaseExecutor;
import lclang.LCRootExecutor;
import lclang.Value;
import lclang.exceptions.LCLangException;
import org.jetbrains.annotations.NotNull;

public abstract class Statement {
    public final int line;

    public Statement(int line) {
        this.line = line;
    }

    public abstract Value visit(Caller prevCaller, LCBaseExecutor visitor) throws LCLangException;

    public Caller getCaller(@NotNull Caller caller) {
        return new Caller(caller.root, line, caller);
    }
    public Caller getCaller(@NotNull LCRootExecutor root) {
        return new Caller(root, line, null);
    }
}
