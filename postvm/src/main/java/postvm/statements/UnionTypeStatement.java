package postvm.statements;

import postvm.library.classes.PostVMClass;
import postvm.types.Type;
import postvm.types.UnionType;

import java.util.ArrayList;
import java.util.List;

public class UnionTypeStatement extends TypeStatement {
    public final List<TypeStatement> types;

    public UnionTypeStatement(List<TypeStatement> types) {
        super(0);
        this.types = types;
    }

    @Override
    public Type toType(PostVMClass root) {
        List<Type> types = new ArrayList<>();
        for(TypeStatement type: this.types) types.add(type.toType(root));

        return new UnionType(types);
    }
}
