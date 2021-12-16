package postvm.library.classes.numbers;

import postvm.CacheManager;
import postvm.library.classes.PostVMClass;
import postvm.library.classes.StringClass;
import postvm.types.Type;

public class LongClass extends NumberClass {
    public static final String NAME = "long";
    public static final LongClass INSTANCE = new LongClass();
    public static final Type TYPE = INSTANCE.classType;

    private LongClass() {
        super(NAME);
        constructor = method((caller, lcClasses) -> LongClass.get(
                Long.parseLong(lcClasses.get(0).toString(caller))), PostVMClass.OBJECT_TYPE, TYPE);
    }

    private LongClass(long value) {
        super(NAME);
        this.value = value;
        globals.put("toString", method((caller, lcClasses) -> StringClass.get(String.valueOf(value)),
                StringClass.type));
        globals.put("toBinary", method((caller, lcClasses) -> StringClass.get(Long.toBinaryString(value)),
                StringClass.type));
    }

    public static LongClass get(long value) {
        if(CacheManager.cashedClasses.containsKey(value))
            return (LongClass) CacheManager.cashedClasses.get(value);

        LongClass intClass = new LongClass(value);
        CacheManager.saveCache(value, intClass);
        return intClass;
    }
}
