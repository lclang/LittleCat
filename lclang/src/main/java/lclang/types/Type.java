package lclang.types;

import lclang.libs.lang.classes.NullClass;

public abstract class Type implements Cloneable {
    public final String text;
    public boolean nullable = false;

    public Type(String text) {
        this.text = text;
    }

    public boolean isAccept(Type another) {
        if(NullClass.type.equals(this)) return true;

        if(another.isAccept(NullClass.type))
            return nullable;

        return isAcceptWithoutNullable(another) && (nullable || !another.nullable);
    }

    public boolean isAcceptWithoutNullable(Type another) {
        return false;
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
    public String toString() {
        return (nullable ? "?": "") + text;
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
