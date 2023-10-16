package postvm.statements;

import postvm.Caller;
import postvm.exceptions.LCLangRuntimeException;
import postvm.classes.PostVMClassInstance;
import postvm.types.Type;

public abstract class TypeStatement {
    public final int line;
    public boolean nullable;

    public TypeStatement(int line) {
        this.line = line;
    }

    public abstract Type toType(PostVMClassInstance root) throws LCLangRuntimeException;
    public final int getCaller(PostVMClassInstance root) {
        return Caller.register(root.classId, line, Caller.CALLER_NONE);
    }
}
