package lclang.statements;

import lclang.Caller;
import lclang.LCRootExecutor;
import lclang.exceptions.LCLangException;
import lclang.types.Type;

public abstract class TypeStatement {
    public final int line;
    public boolean nullable;

    public TypeStatement(int line) {
        this.line = line;
    }

    public abstract Type toType(LCRootExecutor root) throws LCLangException;
    public final Caller getCaller(LCRootExecutor root) {
        return new Caller(root, line);
    }
}
