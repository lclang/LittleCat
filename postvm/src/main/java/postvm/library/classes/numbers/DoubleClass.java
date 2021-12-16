package postvm.library.classes.numbers;

import postvm.CacheManager;
import postvm.library.classes.PostVMClass;
import postvm.library.classes.StringClass;
import postvm.types.Type;

public class DoubleClass extends NumberClass {
    public static final String NAME = "double";
    public static final DoubleClass INSTANCE = new DoubleClass();
    public static final Type TYPE = INSTANCE.classType;

    private DoubleClass() {
        super(NAME);
        constructor = method((caller, lcClasses) -> DoubleClass.get(
                Double.parseDouble(lcClasses.get(0).toString(caller))), PostVMClass.OBJECT_TYPE, TYPE);
    }

    private DoubleClass(double value) {
        super(NAME);
        this.value = value;
        globals.put("toString", method((caller, lcClasses) -> StringClass.get(String.valueOf(value)),
                StringClass.type));
        globals.put("toHex", method((caller, lcClasses) -> StringClass.get(Double.toHexString(value)),
                StringClass.type));
    }

    public static DoubleClass get(double value) {
        if(CacheManager.cashedClasses.containsKey(value))
            return (DoubleClass) CacheManager.cashedClasses.get(value);

        DoubleClass intClass = new DoubleClass(value);
        CacheManager.saveCache(value, intClass);
        return intClass;
    }
}
