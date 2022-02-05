package postvm.library.classes.numbers;

import postvm.Caller;
import postvm.Utils;
import postvm.library.classes.*;
import postvm.types.Type;

import java.util.List;
import java.util.Objects;

public final class NumberClass extends LibraryClass {
    public static final PostVMClassPrototype PROTOTYPE = new PostVMClassPrototype(
            "number",
            PostVMClass.PROTOTYPE,
            Utils.listOf()
    ) {
        @Override
        public PostVMClass createClass(Caller caller, List<PostVMClass> args) {
            return new NumberClass(0);
        }
    };

    public static final Type TYPE = PROTOTYPE.type;
    public Number value;

    public NumberClass(Number value) {
        super(null, PROTOTYPE);
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
            case "equals": return method((caller, args) -> {
                PostVMClass another = args.get(0);
                return BoolClass.get(another.prototype.canCast(NumberClass.PROTOTYPE) &&
                        Objects.equals(another.cast(NumberClass.class).value, value));
            }, PostVMClass.OBJECT_TYPE, BoolClass.type);
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

    public PostVMClass binaryOr(NumberClass another) {
        if (value instanceof Long || another.value instanceof Long)
            return LongClass.get(value.longValue() | another.value.longValue());

        return IntClass.get(value.intValue() | another.value.intValue());
    }

    public PostVMClass binaryAnd(NumberClass another) {
        if (value instanceof Long || another.value instanceof Long)
            return LongClass.get(value.longValue() & another.value.longValue());

        return IntClass.get(value.intValue() & another.value.intValue());
    }

    public PostVMClass binaryLeftShift(NumberClass another) {
        if (value instanceof Long || another.value instanceof Long)
            return LongClass.get(value.longValue() << another.value.longValue());

        return IntClass.get(value.intValue() << another.value.intValue());
    }

    public PostVMClass binaryRightShift(NumberClass another) {
        if (value instanceof Long || another.value instanceof Long)
            return LongClass.get(value.longValue() >> another.value.longValue());

        return IntClass.get(value.intValue() >> another.value.intValue());
    }


    public PostVMClass binaryXOr(NumberClass another) {
        if (value instanceof Long || another.value instanceof Long)
            return LongClass.get(value.longValue() ^ another.value.longValue());

        return IntClass.get(value.intValue() ^ another.value.intValue());
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

    public PostVMClass compliment() {
        if(value instanceof Long)
            return LongClass.get(~value.longValue());

        return IntClass.get(~value.intValue());
    }
}
