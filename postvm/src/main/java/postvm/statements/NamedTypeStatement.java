package postvm.statements;

import postvm.exceptions.LCLangClassNotFoundException;
import postvm.library.classes.ObjectClassInstance;
import postvm.classes.PostVMClassInstance;
import postvm.classes.PostVMClassPrototype;
import postvm.library.classes.VoidClassInstance;
import postvm.types.Type;

public class NamedTypeStatement extends TypeStatement {
    public static final NamedTypeStatement ANY = new NamedTypeStatement(ObjectClassInstance.OBJECT_TYPE.clazz.name, 0);
    public static final NamedTypeStatement VOID = new NamedTypeStatement(VoidClassInstance.PROTOTYPE.type.clazz.name, 0);
    
    public final String name;

    public NamedTypeStatement(String name, int line) {
        super(line);
        this.name = name;
    }

    @Override
    public Type toType(PostVMClassInstance root) throws LCLangClassNotFoundException {
        PostVMClassPrototype clazz = root.getClass(name);
        if(clazz!=null) {
            Type type = new Type(clazz);
            type.nullable = nullable;

            return type;
        }

        throw new LCLangClassNotFoundException(name, getCaller(root));
    }
}
