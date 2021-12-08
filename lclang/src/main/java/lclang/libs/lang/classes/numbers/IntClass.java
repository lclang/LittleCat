package lclang.libs.lang.classes.numbers;

import lclang.libs.lang.classes.StringClass;
import lclang.types.Type;
import lclang.types.Types;

import java.util.HashMap;
import java.util.Map;

public class IntClass extends NumberClass {
    public static final String NAME = "int";
    public static final Map<Integer, IntClass> CACHE = new HashMap<>();
    public static final IntClass INSTANCE = new IntClass();
    public static final Type TYPE = INSTANCE.classType;
    public int value;

    private IntClass() {
        super(NAME);
        constructor = method((caller, lcClasses) -> IntClass.get(
                Integer.parseInt(lcClasses.get(0).toString(caller))), Types.ANY, TYPE);
    }

    private IntClass(int value) {
        super(NAME, value);
        this.value = value;
        globals.put("toString", method((caller, lcClasses) -> StringClass.get(String.valueOf(value)),
                StringClass.type));
        globals.put("toBinary", method((caller, lcClasses) -> StringClass.get(Integer.toBinaryString(value)),
                StringClass.type));
    }

    public static IntClass get(int value) {
        if(CACHE.containsKey(value))
            return CACHE.get(value);

        IntClass intClass = new IntClass(value);
        CACHE.put(value, intClass);
        return intClass;
    }
}
