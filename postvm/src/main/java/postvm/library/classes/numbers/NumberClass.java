package postvm.library.classes.numbers;

import postvm.library.classes.BoolClass;
import postvm.library.classes.CharClass;
import postvm.library.classes.LibraryClass;
import postvm.library.classes.StringClass;
import postvm.types.Type;

public class NumberClass extends LibraryClass {
    public static final String NAME = "number";
    public static final NumberClass INSTANCE = new NumberClass();
    public static final Type TYPE = INSTANCE.classType;
    public Number value;

    private NumberClass() {
        super(NAME);
    }

    public NumberClass(String name) {
        super(name);

        extendsClass = INSTANCE;
        globals.put("toInt", method((caller, lcClasses) -> IntClass.get(value.intValue()),
                IntClass.TYPE));
        globals.put("toLong", method((caller, lcClasses) -> LongClass.get(value.longValue()),
                LongClass.TYPE));
        globals.put("toDouble", method((caller, lcClasses) -> DoubleClass.get(value.doubleValue()),
                DoubleClass.TYPE));
        globals.put("toChar", method((caller, lcClasses) -> CharClass.get((char) value.intValue()),
                CharClass.type));
        globals.put("toString", method((caller, lcClasses) -> StringClass.get(String.valueOf(value)),
                StringClass.type));
    }

    public NumberClass add(NumberClass another) {
        if (this instanceof DoubleClass || another instanceof DoubleClass)
            return DoubleClass.get(value.doubleValue() + another.value.doubleValue());
        else if (this instanceof LongClass || another instanceof LongClass)
            return LongClass.get(value.longValue() + another.value.longValue());

        return IntClass.get(value.intValue() + another.value.intValue());
    }

    public NumberClass minus(NumberClass another) {
        if (this instanceof DoubleClass || another instanceof DoubleClass)
            return DoubleClass.get(value.doubleValue() - another.value.doubleValue());
        else if (this instanceof LongClass || another instanceof LongClass)
            return LongClass.get(value.longValue() - another.value.longValue());

        return IntClass.get(value.intValue() - another.value.intValue());
    }

    public NumberClass multiplication(NumberClass another) {
        if (this instanceof DoubleClass || another instanceof DoubleClass)
            return DoubleClass.get(value.doubleValue() * another.value.doubleValue());
        else if (this instanceof LongClass || another instanceof LongClass)
            return LongClass.get(value.longValue() * another.value.longValue());

        return IntClass.get(value.intValue() * another.value.intValue());
    }

    public NumberClass div(NumberClass another) {
        return DoubleClass.get(value.doubleValue() / another.value.doubleValue());
    }

    public NumberClass pow(NumberClass another) {
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
