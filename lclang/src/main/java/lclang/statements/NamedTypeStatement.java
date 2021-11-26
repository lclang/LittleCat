package lclang.statements;

import lclang.LCRootExecutor;
import lclang.exceptions.ClassNotFoundException;
import lclang.types.NamedType;

public class NamedTypeStatement extends TypeStatement {
    public final String name;

    public NamedTypeStatement(String name, int line) {
        super(line);
        this.name = name;
    }

    @Override
    public NamedType toType(LCRootExecutor root) throws ClassNotFoundException {
        if(root.classes.containsKey(name)) {
            NamedType type = new NamedType(root.classes.get(name));
            type.nullable = nullable;

            return type;
        }

        throw new ClassNotFoundException(name, getCaller(root));
    }
}
