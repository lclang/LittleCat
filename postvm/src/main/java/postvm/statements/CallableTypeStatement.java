package postvm.statements;

import postvm.exceptions.LCLangRuntimeException;
import postvm.library.classes.PostVMClass;
import postvm.types.CallableType;
import postvm.types.Type;

import java.util.ArrayList;
import java.util.List;

public class CallableTypeStatement extends TypeStatement {
    public final List<TypeStatement> args;
    public final TypeStatement returnType;

    public CallableTypeStatement(List<TypeStatement> args, TypeStatement returnType, int line) {
        super(line);
        this.args = args;
        this.returnType = returnType;
    }

    @Override
    public CallableType toType(PostVMClass root) throws LCLangRuntimeException {
        List<Type> types = new ArrayList<>();
        for (TypeStatement arg: args)
            types.add(arg.toType(root));

        CallableType callableType = new CallableType(types, returnType.toType(root));
        callableType.nullable = nullable;
        return callableType;
    }
}
