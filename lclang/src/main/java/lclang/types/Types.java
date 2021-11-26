package lclang.types;

import lclang.libs.lang.classes.*;
import lclang.libs.lang.classes.numbers.DoubleClass;
import lclang.libs.lang.classes.numbers.IntClass;
import org.jetbrains.annotations.NotNull;

public class Types {
    public static MagicType VOID = new MagicType("void");
    public static MagicType ANY = new MagicType("any");
    public static MagicType CALLABLE = new MagicType("callable");
    public static MagicType UNDEFINED = new MagicType("undefined");
    public static MagicType NULL = NullClass.getType();

    public static MagicType INT = IntClass.type;
    public static MagicType LONG = new MagicType("long");
    public static MagicType DOUBLE = DoubleClass.type;
    public static MagicType BOOL = BoolClass.type;
    public static MagicType STRING = StringClass.type;
    public static MagicType CHAR = CharClass.type;
    public static MagicType ARRAY = ArrayClass.type;

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
