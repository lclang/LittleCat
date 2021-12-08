package lclang.types;

import lclang.libs.lang.classes.LCClass;

public class NamedType extends Type {
    public final LCClass clazz;
    public NamedType(LCClass clazz) {
        super(clazz.name);
        this.clazz = clazz;
    }

    @Override
    public boolean isAcceptWithoutNullable(Type another) {
        return super.isAcceptWithoutNullable(another) || (
                another instanceof NamedType &&
                ((NamedType) another).clazz.canCast(clazz));
    }
}
