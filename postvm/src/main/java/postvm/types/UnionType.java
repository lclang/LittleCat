package postvm.types;

import postvm.Utils;
import postvm.methods.Method;

import java.util.Arrays;
import java.util.List;

public class UnionType extends Type {
    public final List<Type> types;

    public UnionType(List<Type> types) {
        super(Method.INSTANCE);
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
        return new UnionType(Arrays.asList(args));
    }

    @Override
    public String toString() {
        return Utils.joinToString("|", types, Type::toString);
    }
}
