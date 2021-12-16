package postvm.statements;

import postvm.Caller;
import postvm.PostVMRoot;
import postvm.exceptions.LCLangRuntimeException;
import postvm.types.Type;

public abstract class TypeStatement {
    public final int line;
    public boolean nullable;

    public TypeStatement(int line) {
        this.line = line;
    }

    public abstract Type toType(PostVMRoot root) throws LCLangRuntimeException;
    public final Caller getCaller(PostVMRoot root) {
        return new Caller(root, line);
    }
}
