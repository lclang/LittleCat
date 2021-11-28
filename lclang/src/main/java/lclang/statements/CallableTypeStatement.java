package lclang.statements;

import lclang.LCRootExecutor;
import lclang.exceptions.LCLangRuntimeException;
import lclang.types.CallableType;
import lclang.types.Type;

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
    public CallableType toType(LCRootExecutor root) throws LCLangRuntimeException {
        List<Type> types = new ArrayList<>();
        for (TypeStatement arg: args)
            types.add(arg.toType(root));

        CallableType callableType = new CallableType(types, returnType.toType(root));
        callableType.nullable = nullable;
        return callableType;
    }
}
