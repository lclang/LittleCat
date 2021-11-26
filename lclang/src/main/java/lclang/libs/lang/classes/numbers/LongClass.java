package lclang.libs.lang.classes.numbers;

import lclang.libs.lang.classes.StringClass;
import lclang.types.Types;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LongClass extends NumberClass {
    public static final String name = "long";
    public static final LongClass instance = new LongClass();
    public static final Map<Long, LongClass> cache = new HashMap<>();
    public static final Types.MagicType type = new Types.MagicType(name);
    public long value;

    private LongClass() {
        super(name);
        constructor = method((caller, lcClasses) -> LongClass.get(
                Long.parseLong(lcClasses.get(0).toString(caller))), Types.ANY, type);
    }

    private LongClass(long value) {
        super(name, value);
        this.value = value;
        globals.put("toString", method((caller, lcClasses) -> StringClass.get(String.valueOf(value)),
                Types.STRING).asValue());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        LongClass intClass = (LongClass) o;
        return value == intClass.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), value);
    }

    public static LongClass get(long value) {
        if(cache.containsKey(value))
            return cache.get(value);

        LongClass intClass = new LongClass(value);
        cache.put(value, intClass);
        return intClass;
    }
}
