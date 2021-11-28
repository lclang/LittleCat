package lclang.libs.lang.classes.numbers;

import lclang.libs.lang.classes.StringClass;
import lclang.types.Types;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class IntClass extends NumberClass {
    public static final String name = "int";
    public static final Types.MagicType type = new Types.MagicType(name);
    public static final Map<Integer, IntClass> cache = new HashMap<>();
    public static final IntClass instance = new IntClass();
    public int value;

    private IntClass() {
        super(name);
        constructor = method((caller, lcClasses) -> IntClass.get(
                Integer.parseInt(lcClasses.get(0).toString(caller))), Types.ANY, type);
    }

    private IntClass(int value) {
        super(name, value);
        this.value = value;
        globals.put("toString", method((caller, lcClasses) -> StringClass.get(String.valueOf(value)),
                StringClass.type).asValue());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        IntClass intClass = (IntClass) o;
        return value == intClass.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), value);
    }

    public static IntClass get(int value) {
        if(cache.containsKey(value))
            return cache.get(value);

        IntClass intClass = new IntClass(value);
        cache.put(value, intClass);
        return intClass;
    }
}
