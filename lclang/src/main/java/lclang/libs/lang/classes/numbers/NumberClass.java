package lclang.libs.lang.classes.numbers;

import lclang.libs.lang.classes.BoolClass;
import lclang.libs.lang.classes.CharClass;
import lclang.libs.lang.classes.LibraryClass;
import lclang.libs.lang.classes.StringClass;
import lclang.types.Type;

public class NumberClass extends LibraryClass {
    public static final String NAME = "number";
    public static final NumberClass INSTANCE = new NumberClass();
    public static final Type TYPE = INSTANCE.classType;
    public Number number;

    private NumberClass() {
        super(NAME);
    }

    public NumberClass(String name) {
        super(name);
        extendsClass = INSTANCE;
    }

    public NumberClass(String name, Number number) {
        this(name);
        this.number = number;

        extendsClass = INSTANCE;
        globals.put("toInt", method((caller, lcClasses) -> IntClass.get(number.intValue()),
                IntClass.TYPE));
        globals.put("toLong", method((caller, lcClasses) -> LongClass.get(number.longValue()),
                LongClass.TYPE));
        globals.put("toDouble", method((caller, lcClasses) -> DoubleClass.get(number.doubleValue()),
                DoubleClass.TYPE));
        globals.put("toChar", method((caller, lcClasses) -> CharClass.get((char) number.intValue()),
                CharClass.type));
        globals.put("toString", method((caller, lcClasses) -> StringClass.get(String.valueOf(number)),
                StringClass.type));
    }

    public NumberClass add(NumberClass another) {
        if (this instanceof DoubleClass || another instanceof DoubleClass)
            return DoubleClass.get(number.doubleValue() + another.number.doubleValue());
        else if (this instanceof LongClass || another instanceof LongClass)
            return LongClass.get(number.longValue() + another.number.longValue());

        return IntClass.get(number.intValue() + another.number.intValue());
    }

    public NumberClass minus(NumberClass another) {
        if (this instanceof DoubleClass || another instanceof DoubleClass)
            return DoubleClass.get(number.doubleValue() - another.number.doubleValue());
        else if (this instanceof LongClass || another instanceof LongClass)
            return LongClass.get(number.longValue() - another.number.longValue());

        return IntClass.get(number.intValue() - another.number.intValue());
    }

    public NumberClass multiplication(NumberClass another) {
        if (this instanceof DoubleClass || another instanceof DoubleClass)
            return DoubleClass.get(number.doubleValue() * another.number.doubleValue());
        else if (this instanceof LongClass || another instanceof LongClass)
            return LongClass.get(number.longValue() * another.number.longValue());

        return IntClass.get(number.intValue() * another.number.intValue());
    }

    public NumberClass div(NumberClass another) {
        return DoubleClass.get(number.doubleValue() / another.number.doubleValue());
    }

    public NumberClass pow(NumberClass another) {
        return DoubleClass.get(Math.pow(number.doubleValue(), another.number.doubleValue()));
    }

    public BoolClass larger(NumberClass another) {
        return BoolClass.get(number.doubleValue()>another.number.doubleValue());
    }

    public BoolClass largerEquals(NumberClass another) {
        return BoolClass.get(number.doubleValue()>=another.number.doubleValue());
    }

    public BoolClass less(NumberClass another) {
        return BoolClass.get(number.doubleValue()<another.number.doubleValue());
    }

    public BoolClass lessEquals(NumberClass another) {
        return BoolClass.get(number.doubleValue()<=another.number.doubleValue());
    }
}
