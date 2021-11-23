package lclang.statements;

import lclang.Caller;
import lclang.LCBaseExecutor;
import lclang.LCRootExecutor;
import lclang.Value;
import lclang.exceptions.LCLangException;
import org.jetbrains.annotations.NotNull;

public abstract class Statement {
    public final int line;
    public final int column;

    public Statement(int line, int column) {
        this.line = line;
        this.column = column;
    }

    public abstract Value visit(Caller prevCaller, LCBaseExecutor visitor) throws LCLangException;

    public Caller getCaller(@NotNull Caller caller) {
        return new Caller(caller.root, line, column, caller);
    }
    public Caller getCaller(@NotNull LCRootExecutor root) {
        return new Caller(root, line, column, null);
    }
}
