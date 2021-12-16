package postvm.library.classes;

import postvm.types.Type;

public class BoolClass extends LibraryClass {
    public static final String name = "bool";
    public static final BoolClass instance = new BoolClass();
    public static final Type type = instance.classType;
    public static final BoolClass TRUE = new BoolClass(true);
    public static final BoolClass FALSE = new BoolClass(false);

    public boolean bool;
    private BoolClass() {
        super(name);
    }
    private BoolClass(boolean bool) {
        this();
        this.bool = bool;
        globals.put("toString", method((caller, lcClasses) -> StringClass.get(String.valueOf(bool)), StringClass.type));
    }

    public static BoolClass get(boolean bool) {
        return bool ? TRUE: FALSE;
    }
}
