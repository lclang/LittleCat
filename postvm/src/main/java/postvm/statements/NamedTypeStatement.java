package postvm.statements;

import postvm.PostVMRoot;
import postvm.exceptions.LCLangClassNotFoundException;
import postvm.types.Type;

public class NamedTypeStatement extends TypeStatement {
    public final String name;

    public NamedTypeStatement(String name, int line) {
        super(line);
        this.name = name;
    }

    @Override
    public Type toType(PostVMRoot root) throws LCLangClassNotFoundException {
        if(root.classes.containsKey(name)) {
            Type type = new Type(root.classes.get(name));
            type.nullable = nullable;

            return type;
        }

        throw new LCLangClassNotFoundException(name, getCaller(root));
    }
}
