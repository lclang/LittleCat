package postvm.library.classes.numbers;

import postvm.CacheManager;
import postvm.exceptions.LCLangIOException;
import postvm.library.classes.LibraryClass;
import postvm.library.classes.PostVMClass;
import postvm.library.classes.StringClass;
import postvm.types.Type;

public final class DoubleClass extends LibraryClass {
    public static final String NAME = "double";
    public static final DoubleClass INSTANCE = new DoubleClass();
    public static final Type TYPE = INSTANCE.classType;
    public double value;

    private DoubleClass() {
        super(NAME);
        constructor = method((caller, lcClasses) -> {
            try {
                return DoubleClass.get(Double.parseDouble(lcClasses.get(0).toString(caller)));
            } catch (NumberFormatException e) {
                throw new LCLangIOException("Invalid number format "+e.getMessage().toLowerCase(), caller);
            }
        }, PostVMClass.OBJECT_TYPE, TYPE);
    }

    private DoubleClass(double value) {
        super(NAME);
        this.value = value;
        this.extendsClass = new NumberClass(value);
    }

    @Override
    public PostVMClass loadGlobal(String target) {
        switch (target) {
            case "toBinary": return method((caller, lcClasses) ->
                            StringClass.get(Long.toBinaryString((long) value)),
                    StringClass.type);
            case "toHex": return method((caller, lcClasses) ->
                            StringClass.get(Double.toHexString(value)),
                    StringClass.type);
        }

        return super.loadGlobal(target);
    }

    public static DoubleClass get(double value) {
        if(CacheManager.cashedClasses.containsKey(value))
            return (DoubleClass) CacheManager.cashedClasses.get(value);

        DoubleClass intClass = new DoubleClass(value);
        CacheManager.saveCache(value, intClass);
        return intClass;
    }
}
