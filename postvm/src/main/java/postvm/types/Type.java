package postvm.types;

import postvm.library.classes.NullClass;
import postvm.library.classes.PostVMClassPrototype;

public class Type implements Cloneable {
    public boolean nullable = false;
    public final PostVMClassPrototype clazz;

    public Type(PostVMClassPrototype clazz) {
        this.clazz = clazz;
    }

    public boolean isAccept(Type another) {
        if(NullClass.PROTOTYPE==clazz) return true;

        if(another.clazz==NullClass.PROTOTYPE)
            return nullable;

        return isAcceptWithoutNullable(another) && (nullable || !another.nullable);
    }

    public boolean isAcceptWithoutNullable(Type another) {
        return another.clazz.canCast(clazz);
    }

    @Override
    public String toString() {
        return clazz.name;
    }

    public Type nullable() {
        Type newType = clone();
        newType.nullable = true;
        return newType;
    }

    public Type notNullable() {
        Type newType = clone();
        newType.nullable = true;
        return newType;
    }

    @Override
    public Type clone(){
        try {
            return (Type) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
