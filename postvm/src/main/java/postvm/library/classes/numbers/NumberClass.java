package postvm.library.classes.numbers;

import postvm.library.classes.*;
import postvm.types.Type;

public final class NumberClass extends LibraryClass {
    public static final String NAME = "number";
    public static final NumberClass INSTANCE = new NumberClass();
    public static final Type TYPE = INSTANCE.classType;
    public Number value;

    private NumberClass() {
        super(NAME);
    }

    public NumberClass(String name) {
        super(name);
    }

    public NumberClass(Number value) {
        super(NAME);
        this.value = value;
    }

    @Override
    public PostVMClass loadGlobal(String target) {
        switch (target) {
            case "toInt": return method((caller, lcClasses) -> IntClass.get(value.intValue()),
                    IntClass.TYPE);
            case "toLong": return method((caller, lcClasses) -> LongClass.get(value.longValue()),
                    LongClass.TYPE);
            case "toDouble": return method((caller, lcClasses) -> DoubleClass.get(value.doubleValue()),
                    DoubleClass.TYPE);
            case "toChar": return method((caller, lcClasses) -> CharClass.get((char) value.intValue()),
                    CharClass.type);
            case "toString": return method((caller, lcClasses) -> StringClass.get(String.valueOf(value)),
                    StringClass.type);
        }

        return super.loadGlobal(target);
    }

    public PostVMClass add(NumberClass another) {
        if (value instanceof Double || another.value instanceof Double)
            return DoubleClass.get(value.doubleValue() + another.value.doubleValue());
        else if (value instanceof Long || another.value instanceof Long)
            return LongClass.get(value.longValue() + another.value.longValue());

        return IntClass.get(value.intValue() + another.value.intValue());
    }

    public PostVMClass minus(NumberClass another) {
        if (value instanceof Double || another.value instanceof Double)
            return DoubleClass.get(value.doubleValue() - another.value.doubleValue());
        else if (value instanceof Long || another.value instanceof Long)
            return LongClass.get(value.longValue() - another.value.longValue());

        return IntClass.get(value.intValue() - another.value.intValue());
    }

    public PostVMClass multiplication(NumberClass another) {
        if (value instanceof Double || another.value instanceof Double)
            return DoubleClass.get(value.doubleValue() * another.value.doubleValue());
        else if (value instanceof Long || another.value instanceof Long)
            return LongClass.get(value.longValue() * another.value.longValue());

        return IntClass.get(value.intValue() * another.value.intValue());
    }

    public PostVMClass div(NumberClass another) {
        return DoubleClass.get(value.doubleValue() / another.value.doubleValue());
    }

    public PostVMClass pow(NumberClass another) {
        return DoubleClass.get(Math.pow(value.doubleValue(), another.value.doubleValue()));
    }

    public BoolClass larger(NumberClass another) {
        return BoolClass.get(value.doubleValue()>another.value.doubleValue());
    }

    public BoolClass largerEquals(NumberClass another) {
        return BoolClass.get(value.doubleValue()>=another.value.doubleValue());
    }

    public BoolClass less(NumberClass another) {
        return BoolClass.get(value.doubleValue()<another.value.doubleValue());
    }

    public BoolClass lessEquals(NumberClass another) {
        return BoolClass.get(value.doubleValue()<=another.value.doubleValue());
    }
}
