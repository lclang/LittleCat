package postvm.library.classes;

import postvm.types.Type;

import java.util.Objects;

public final class BoolClass extends LibraryClass {
    public static final String name = "bool";
    public static final BoolClass INSTANCE = new BoolClass();
    public static final Type type = INSTANCE.classType;
    public static final BoolClass TRUE = new BoolClass(true);
    public static final BoolClass FALSE = new BoolClass(false);

    public boolean bool;
    private BoolClass() {
        super(name);
    }
    private BoolClass(boolean bool) {
        super(name);
        this.bool = bool;
    }

    public BoolClass not() {
        return bool ? FALSE: TRUE;
    }

    @Override
    public PostVMClass loadGlobal(String target) {
        if(Objects.equals(target, "toString")) return method((caller, lcClasses) ->
                StringClass.get(String.valueOf(bool)), StringClass.type);
        return super.loadGlobal(target);
    }

    public static BoolClass get(boolean bool) {
        return bool ? TRUE: FALSE;
    }
}
