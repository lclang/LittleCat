package lclang.types;

import java.util.Objects;

public abstract class Type implements Cloneable {
    public final String text;
    public boolean nullable = false;

    public Type(String text) {
        this.text = text;
    }

    public boolean isAccept(Type another) {
        if(
                Types.ANY.equals(this) ||
                Types.NULL.equals(this) ||
                another.equals(Types.UNDEFINED) ||
                another instanceof Types.MagicType &&
                Objects.equals(another.text, text)
        ) return true;

        if(another.equals(Types.NULL))
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
