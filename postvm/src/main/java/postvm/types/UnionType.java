package postvm.types;

import postvm.Utils;
import postvm.library.classes.ObjectClass;
import postvm.library.classes.PostVMClass;
import postvm.methods.Method;

import java.util.Arrays;
import java.util.List;

public class UnionType extends Type {
    public final Type[] types;

    public UnionType(Type[] types) {
        super(ObjectClass.PROTOTYPE);
        this.types = types;
        this.nullable = false;
    }

    @Override
    public boolean isAcceptWithoutNullable(Type another) {
        for(Type type: types) if(type.isAccept(another))
            return true;

        return false;
    }

    public static UnionType get(Type... args) {
        return new UnionType(args);
    }

    @Override
    public String toString() {
        return Utils.joinToString("|", Arrays.asList(types), Type::toString);
    }
}
