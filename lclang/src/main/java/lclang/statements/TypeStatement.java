package lclang.statements;

import lclang.Caller;
import lclang.LCRootExecutor;
import lclang.exceptions.LCLangRuntimeException;
import lclang.types.Type;

public abstract class TypeStatement {
    public final int line;
    public boolean nullable;

    public TypeStatement(int line) {
        this.line = line;
    }

    public abstract Type toType(LCRootExecutor root) throws LCLangRuntimeException;
    public final Caller getCaller(LCRootExecutor root) {
        return new Caller(root, line);
    }
}
