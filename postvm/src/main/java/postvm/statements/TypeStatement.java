package postvm.statements;

import postvm.Caller;
import postvm.exceptions.LCLangRuntimeException;
import postvm.library.classes.PostVMClass;
import postvm.types.Type;

public abstract class TypeStatement {
    public final int line;
    public boolean nullable;

    public TypeStatement(int line) {
        this.line = line;
    }

    public abstract Type toType(PostVMClass root) throws LCLangRuntimeException;
    public final Caller getCaller(PostVMClass root) {
        return new Caller(root, line);
    }
}
