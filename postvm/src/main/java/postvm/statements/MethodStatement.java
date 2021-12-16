package postvm.statements;

import postvm.PostVMRoot;
import postvm.exceptions.LCLangRuntimeException;
import postvm.methods.MethodImpl;
import postvm.types.Type;

import java.util.ArrayList;
import java.util.List;

public class MethodStatement {
    public final String name;
    public final List<Argument> args;
    public final TypeStatement returnType;
    public final Statement statement;

    public MethodStatement(
            String name,
            List<Argument> args,
            TypeStatement returnType,
            Statement statement
    ) {
        this.name = name;
        this.args = args;
        this.returnType = returnType;
        this.statement = statement;
    }

    public void visit(PostVMRoot root, boolean importVariables) throws LCLangRuntimeException {
        root.globals.put(name, new MethodImpl(
                root.executor,
                args,
                returnType.toType(root),
                statement,
                importVariables
        ));
    }

    public static List<Type> resolveArgs(PostVMRoot root, List<Argument> args) throws LCLangRuntimeException {
        List<Type> types = new ArrayList<>();
        for(Argument argument: args) types.add(argument.type.toType(root));
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
