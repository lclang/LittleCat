package postvm.statements;

import postvm.library.classes.PostVMClass;
import postvm.types.Type;
import postvm.types.UnionType;

import java.util.ArrayList;
import java.util.List;

public class UnionTypeStatement extends TypeStatement {
    public final TypeStatement[] types;

    public UnionTypeStatement(TypeStatement[] types) {
        super(0);
        this.types = types;
    }

    @Override
    public Type toType(PostVMClass root) {
        Type[] types = new Type[this.types.length];
        for (int i = 0, l = types.length; i < l; i++) {
            types[i] = this.types[i].toType(root);
        }

        return new UnionType(types);
    }
}
