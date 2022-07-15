package postvm.statements;

import postvm.exceptions.LCLangRuntimeException;
import postvm.library.classes.PostVMClass;
import postvm.methods.MethodImpl;
import postvm.types.Type;

import java.util.ArrayList;
import java.util.List;

public class MethodStatement {
    public final String name;
    public final Argument[] args;
    public final TypeStatement returnType;
    public final Statement statement;

    public MethodStatement(
            String name,
            Argument[] args,
            TypeStatement returnType,
            Statement statement
    ) {
        this.name = name;
        this.args = args;
        this.returnType = returnType;
        this.statement = statement;
    }

    public int visit(PostVMClass root, boolean importVariables) throws LCLangRuntimeException {
        return new MethodImpl(
                root.executor,
                args,
                returnType.toType(root),
                statement,
                importVariables
        ).classId;
    }

    public static Type[] resolveArgs(PostVMClass root, Argument[] args) throws LCLangRuntimeException {
        Type[] types = new Type[args.length];
        for (int i = 0, l = args.length; i < l; i++) {
            types[i] = args[i].type.toType(root);
        }

        return types;
    }

    public static class Argument {
        public final String name;
        public final TypeStatement type;

        public Argument(String name, TypeStatement type) {
            this.name = name;
            this.type = type;
        }
    }
}
