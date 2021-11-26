package lclang.libs.lang.classes;

import lclang.types.Types;

public class BoolClass extends LibraryClass {
    public static final String name = "bool";
    public static final Types.MagicType type = new Types.MagicType(name);
    public static final BoolClass instance = new BoolClass();
    public static final BoolClass TRUE = new BoolClass(true);
    public static final BoolClass FALSE = new BoolClass(false);

    public boolean bool;
    private BoolClass() {
        super(name);
    }
    private BoolClass(boolean bool) {
        this();
        this.bool = bool;
        globals.put("toString", method((caller, lcClasses) -> StringClass.get(String.valueOf(bool)),
                Types.STRING).asValue());
    }

    @Override
    public boolean equals(Object other) {
        if(other instanceof BoolClass)
            return ((BoolClass) other).bool == bool;

        return false;
    }

    public static BoolClass get(boolean bool) {
        return bool ? TRUE: FALSE;
    }
}
