package postvm.types;

import postvm.Utils;
import postvm.library.classes.ObjectClassInstance;

import java.util.Arrays;

public class UnionType extends Type {
    public final Type[] types;

    public UnionType(Type[] types) {
        super(ObjectClassInstance.PROTOTYPE);
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
