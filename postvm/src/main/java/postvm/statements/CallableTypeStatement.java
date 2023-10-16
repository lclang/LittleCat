package postvm.statements;

import postvm.exceptions.LCLangRuntimeException;
import postvm.classes.PostVMClassInstance;
import postvm.types.CallableType;
import postvm.types.Type;

public class CallableTypeStatement extends TypeStatement {
    public final TypeStatement[] args;
    public final TypeStatement returnType;

    public CallableTypeStatement(TypeStatement[] args, TypeStatement returnType, int line) {
        super(line);
        this.args = args;
        this.returnType = returnType;
    }

    @Override
    public CallableType toType(PostVMClassInstance root) throws LCLangRuntimeException {
        Type[] types = new Type[args.length];
        for (int i = 0, l = args.length; i < l; i++)
            types[i] = args[i].toType(root);

        CallableType callableType = new CallableType(types, returnType.toType(root));
        callableType.nullable = nullable;
        return callableType;
    }
}
