package postvm.library.classes.numbers;

import postvm.CacheManager;
import postvm.library.classes.LibraryClass;
import postvm.library.classes.PostVMClass;
import postvm.library.classes.StringClass;
import postvm.types.Type;

public final class IntClass extends LibraryClass {
    public static final String NAME = "int";
    public static final IntClass INSTANCE = new IntClass();
    public static final Type TYPE = INSTANCE.classType;
    public int value;

    private IntClass() {
        super(NAME);
        constructor = method((caller, lcClasses) -> IntClass.get(
                Integer.parseInt(lcClasses.get(0).toString(caller))), PostVMClass.OBJECT_TYPE, TYPE);
    }

    private IntClass(int value) {
        super(NAME);
        this.value = value;
        extendsClass = new NumberClass(value);
    }

    @Override
    public PostVMClass loadGlobal(String target) {
        switch (target) {
            case "toBinary": return method((caller, lcClasses) ->
                            StringClass.get(Integer.toBinaryString(value)),
                    StringClass.type);
        }

        return super.loadGlobal(target);
    }

    public static IntClass get(int value) {
        if(CacheManager.cashedClasses.containsKey(value))
            return (IntClass) CacheManager.cashedClasses.get(value);

        IntClass intClass = new IntClass(value);
        CacheManager.saveCache(value, intClass);
        return intClass;
    }
}
