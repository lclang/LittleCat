package postvm.statements;

import postvm.PostVMRoot;
import postvm.library.classes.PostVMClass;
import postvm.library.classes.VoidClass;
import postvm.types.Type;

public class MagicTypeStatement extends TypeStatement {
    public static final MagicTypeStatement ANY = new MagicTypeStatement(PostVMClass.OBJECT_TYPE);
    public static final MagicTypeStatement VOID = new MagicTypeStatement(VoidClass.type);
    public final Type type;

    public MagicTypeStatement(Type type) {
        super(0);
        this.type = type;
    }

    @Override
    public Type toType(PostVMRoot root) {
        return type;
    }
}