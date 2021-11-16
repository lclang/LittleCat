package lclang.types;

import lclang.libs.lang.BoolClass;
import org.jetbrains.annotations.NotNull;

public class Types {
    public static MagicType VOID = new MagicType("void");
    public static MagicType ANY = new MagicType("any");
    public static MagicType CALLABLE = new MagicType("callable");
    public static MagicType UNDEFINED = new MagicType("undefined");

    public static MagicType INT = new MagicType("int");
    public static MagicType LONG = new MagicType("long");
    public static MagicType BOOL = BoolClass.getType();
    public static MagicType STRING = new MagicType("string");
    public static MagicType CHAR = new MagicType("char");
    public static MagicType ARRAY = new MagicType("array");
    public static MagicType DOUBLE = new MagicType("double");

    public static class MagicType extends Type {

        public MagicType(@NotNull String name) {
            super(name);
        }

        @Override
        public boolean isAcceptWithoutNullable(@NotNull Type another) {
            if(another instanceof NamedType){
                NamedType namedType = (NamedType) another;
                return namedType.clazz.name.equals(text);
            }

            return false;
        }
    }
}
