package lclang.statements;

import lclang.LCRootExecutor;
import lclang.methods.MethodImpl;
import lclang.types.Type;

import java.util.HashMap;
import java.util.Map;

public class MethodStatement {
    public final String name;
    public final Map<String, TypeStatement> args;
    public final TypeStatement returnType;
    public final Statement statement;

    public MethodStatement(
            String name,
            Map<String, TypeStatement> args,
            TypeStatement returnType,
            Statement statement
    ) {
        this.name = name;
        this.args = args;
        this.returnType = returnType;
        this.statement = statement;
    }

    public void visit(LCRootExecutor root) {
        Map<String, Type> argsResolved = new HashMap<>();
        for(Map.Entry<String, TypeStatement> entry: args.entrySet())
            argsResolved.put(entry.getKey(), entry.getValue().toType(root));

        root.globals.put(name, new MethodImpl(
                root.executor,
                argsResolved,
                returnType.toType(root),
                statement
        ).asValue());
    }
}
