package lclang.types;

public class Types {
    public static final MagicType ANY = new MagicType("any");
    public static final MagicType UNDEFINED = new MagicType("undefined");

    public static class MagicType extends Type {
        public MagicType(String name) {
            super(name);
        }

        @Override
        public boolean isAcceptWithoutNullable(Type another) {
            return false;
        }
    }
}
