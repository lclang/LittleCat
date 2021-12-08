package lclang.libs.lang.classes.numbers;

import lclang.libs.lang.classes.StringClass;
import lclang.types.Type;
import lclang.types.Types;

import java.util.HashMap;
import java.util.Map;

public class DoubleClass extends NumberClass {
    public static final String NAME = "double";
    public static final Map<Double, DoubleClass> CACHE = new HashMap<>();
    public static final DoubleClass INSTANCE = new DoubleClass();
    public static final Type TYPE = INSTANCE.classType;
    public double value;

    private DoubleClass() {
        super(NAME);
        constructor = method((caller, lcClasses) -> DoubleClass.get(
                Double.parseDouble(lcClasses.get(0).toString(caller))), Types.ANY, TYPE);
    }

    private DoubleClass(double value) {
        super(NAME, value);
        this.value = value;
        globals.put("toString", method((caller, lcClasses) -> StringClass.get(String.valueOf(value)),
                StringClass.type));
        globals.put("toHex", method((caller, lcClasses) -> StringClass.get(Double.toHexString(value)),
                StringClass.type));
    }

    public static DoubleClass get(double value) {
        if(CACHE.containsKey(value))
            return CACHE.get(value);

        DoubleClass intClass = new DoubleClass(value);
        CACHE.put(value, intClass);
        return intClass;
    }
}
