package lclang.statements;

import lclang.LCRootExecutor;
import lclang.exceptions.LCLangRuntimeException;
import lclang.methods.MethodImpl;
import lclang.types.Type;

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

    public void visit(LCRootExecutor root, boolean importVariables) throws LCLangRuntimeException {
        root.globals.put(name, new MethodImpl(
                root.executor,
                args,
                returnType.toType(root),
                statement,
                importVariables
        ).asValue());
    }

    public static List<Type> resolveArgs(LCRootExecutor root, List<Argument> args) throws LCLangRuntimeException {
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
