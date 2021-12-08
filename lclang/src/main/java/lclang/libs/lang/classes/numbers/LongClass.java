package lclang.libs.lang.classes.numbers;

import lclang.libs.lang.classes.StringClass;
import lclang.types.Type;
import lclang.types.Types;

import java.util.HashMap;
import java.util.Map;

public class LongClass extends NumberClass {
    public static final String NAME = "long";
    public static final Map<Long, LongClass> CACHE = new HashMap<>();
    public static final LongClass INSTANCE = new LongClass();
    public static final Type TYPE = INSTANCE.classType;
    public long value;

    private LongClass() {
        super(NAME);
        constructor = method((caller, lcClasses) -> LongClass.get(
                Long.parseLong(lcClasses.get(0).toString(caller))), Types.ANY, TYPE);
    }

    private LongClass(long value) {
        super(NAME, value);
        this.value = value;
        globals.put("toString", method((caller, lcClasses) -> StringClass.get(String.valueOf(value)),
                StringClass.type));
        globals.put("toBinary", method((caller, lcClasses) -> StringClass.get(Long.toBinaryString(value)),
                StringClass.type));
    }

    public static LongClass get(long value) {
        if(CACHE.containsKey(value))
            return CACHE.get(value);

        LongClass intClass = new LongClass(value);
        CACHE.put(value, intClass);
        return intClass;
    }
}
