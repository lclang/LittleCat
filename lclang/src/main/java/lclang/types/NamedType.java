package lclang.types;

import lclang.LCClass;

import java.util.Objects;

public class NamedType extends Type {
    public final LCClass clazz;
    public NamedType(LCClass clazz) {
        super(clazz.name);
        this.clazz = clazz;
    }

    @Override
    public boolean isAcceptWithoutNullable(Type another) {
        return super.isAcceptWithoutNullable(another) || (
                (another instanceof Types.MagicType &&
                Objects.equals(another.text, clazz.name)) || (
                another instanceof NamedType &&
                ((NamedType) another).clazz.canCast(clazz)));
    }
}
