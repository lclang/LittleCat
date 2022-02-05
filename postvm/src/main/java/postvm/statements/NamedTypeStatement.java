package postvm.statements;

import postvm.exceptions.LCLangClassNotFoundException;
import postvm.library.classes.PostVMClass;
import postvm.library.classes.PostVMClassPrototype;
import postvm.types.Type;

public class NamedTypeStatement extends TypeStatement {
    public final String name;

    public NamedTypeStatement(String name, int line) {
        super(line);
        this.name = name;
    }

    @Override
    public Type toType(PostVMClass root) throws LCLangClassNotFoundException {
        PostVMClassPrototype clazz = root.getClass(name);
        if(clazz!=null) {
            Type type = new Type(clazz);
            type.nullable = nullable;

            return type;
        }

        throw new LCLangClassNotFoundException(name, getCaller(root));
    }
}
