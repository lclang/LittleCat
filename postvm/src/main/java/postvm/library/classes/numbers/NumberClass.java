package postvm.library.classes.numbers;

import postvm.CacheManager;
import postvm.Caller;
import postvm.Utils;
import postvm.exceptions.LCLangRuntimeException;
import postvm.library.classes.*;
import postvm.types.Type;

import java.util.Objects;

public final class NumberClass extends LibraryClass {
    public static final PostVMClassPrototype PROTOTYPE = new PostVMClassPrototype(
            "number",
            ObjectClass.PROTOTYPE,
            Utils.listOf(ObjectClass.OBJECT_TYPE)
    ) {
        @Override
        public int createClass(Caller caller, int[] args) {
            try {
                return NumberClass.get(Integer.parseInt(PostVMClass.instances.get(args[0]).toString(caller)));
            }catch (NumberFormatException exception) {
                throw new LCLangRuntimeException("Invalid number format", exception.getMessage(), caller);
            }
        }
    };

    public static final Type TYPE = PROTOTYPE.type;
    public final Number value;

    private NumberClass(Number value) {
        super(null, PROTOTYPE);
        this.value = value;
    }

    @Override
    public Integer loadGlobal(PostVMClass clazz, String target) {
        switch (target) {
            case "toString": return toStrMethod((caller) -> StringClass.get(String.valueOf(value)));
            case "equals": return method(BoolClass.type, (caller, args) -> {
                PostVMClass another = args[0];
                return BoolClass.get(
                        another.prototype.canCast(NumberClass.PROTOTYPE) &&
                        Objects.equals(((NumberClass) another).value, value)
                );

            }, ObjectClass.OBJECT_TYPE);
        }

        return super.loadGlobal(clazz, target);
    }

    public int add(NumberClass another) {
        if (value instanceof Double || another.value instanceof Double)
            return NumberClass.get(value.doubleValue() + another.value.doubleValue());
        else if (value instanceof Long || another.value instanceof Long)
            return NumberClass.get(value.longValue() + another.value.longValue());

        return NumberClass.get(value.intValue() + another.value.intValue());
    }

    public int minus(NumberClass another) {
        if (value instanceof Double || another.value instanceof Double)
            return NumberClass.get(value.doubleValue() - another.value.doubleValue());
        else if (value instanceof Long || another.value instanceof Long)
            return NumberClass.get(value.longValue() - another.value.longValue());

        return NumberClass.get(value.intValue() - another.value.intValue());
    }

    public int multiplication(NumberClass another) {
        if (value instanceof Double || another.value instanceof Double)
            return NumberClass.get(value.doubleValue() * another.value.doubleValue());
        else if (value instanceof Long || another.value instanceof Long)
            return NumberClass.get(value.longValue() * another.value.longValue());

        return NumberClass.get(value.intValue() * another.value.intValue());
    }

    public int binaryOr(NumberClass another) {
        if (value instanceof Long || another.value instanceof Long)
            return NumberClass.get(value.longValue() | another.value.longValue());

        return NumberClass.get(value.intValue() | another.value.intValue());
    }

    public int binaryAnd(NumberClass another) {
        if (value instanceof Long || another.value instanceof Long)
            return NumberClass.get(value.longValue() & another.value.longValue());

        return NumberClass.get(value.intValue() & another.value.intValue());
    }

    public int binaryLeftShift(NumberClass another) {
        if (value instanceof Long || another.value instanceof Long)
            return NumberClass.get(value.longValue() << another.value.longValue());

        return NumberClass.get(value.intValue() << another.value.intValue());
    }

    public int binaryRightShift(NumberClass another) {
        if (value instanceof Long || another.value instanceof Long)
            return NumberClass.get(value.longValue() >> another.value.longValue());

        return NumberClass.get(value.intValue() >> another.value.intValue());
    }


    public int binaryXOr(NumberClass another) {
        if (value instanceof Long || another.value instanceof Long)
            return NumberClass.get(value.longValue() ^ another.value.longValue());

        return NumberClass.get(value.intValue() ^ another.value.intValue());
    }

    public int div(NumberClass another) {
        return NumberClass.get(value.doubleValue() / another.value.doubleValue());
    }

    public int pow(NumberClass another) {
        return NumberClass.get(Math.pow(value.doubleValue(), another.value.doubleValue()));
    }

    public int larger(NumberClass another) {
        return BoolClass.get(value.doubleValue()>another.value.doubleValue());
    }

    public int largerEquals(NumberClass another) {
        return BoolClass.get(value.doubleValue()>=another.value.doubleValue());
    }

    public int less(NumberClass another) {
        return BoolClass.get(value.doubleValue()<another.value.doubleValue());
    }

    public int lessEquals(NumberClass another) {
        return BoolClass.get(value.doubleValue()<=another.value.doubleValue());
    }

    public int compliment() {
        if(value instanceof Long)
            return NumberClass.get(~value.longValue());

        return NumberClass.get(~value.intValue());
    }

    public static int get(Number value) {
        if(CacheManager.cashedClasses.containsKey(value))
            return CacheManager.cashedClasses.get(value);

        NumberClass NumberClass = new NumberClass(value);
        CacheManager.saveCache(value, NumberClass.classId);
        return NumberClass.classId;
    }
}
