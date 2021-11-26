package lclang.libs.lang.classes.numbers;

import lclang.libs.lang.classes.StringClass;
import lclang.types.Types;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class DoubleClass extends NumberClass {
    public static final String name = "double";
    public static final DoubleClass instance = new DoubleClass();
    public static final Map<Double, DoubleClass> cache = new HashMap<>();
    public static final Types.MagicType type = new Types.MagicType(name);
    public double value;

    private DoubleClass() {
        super(name);
        constructor = method((caller, lcClasses) -> DoubleClass.get(
                Double.parseDouble(lcClasses.get(0).toString(caller))), Types.ANY, type);
    }

    private DoubleClass(double value) {
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
        DoubleClass intClass = (DoubleClass) o;
        return value == intClass.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), value);
    }

    public static DoubleClass get(double value) {
        if(cache.containsKey(value))
            return cache.get(value);

        DoubleClass intClass = new DoubleClass(value);
        cache.put(value, intClass);
        return intClass;
    }
}
