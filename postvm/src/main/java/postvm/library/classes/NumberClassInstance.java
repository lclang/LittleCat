package postvm.library.classes;

import postvm.CacheManager;
import postvm.Caller;
import postvm.Utils;
import postvm.classes.PostVMClassInstance;
import postvm.classes.PostVMClassPrototype;
import postvm.exceptions.LCLangRuntimeException;
import postvm.types.Type;

import java.util.Objects;

public final class NumberClassInstance extends LibraryClassInstance {
    public static final PostVMClassPrototype<NumberClassInstance> PROTOTYPE = new PostVMClassPrototype<NumberClassInstance>(
            "number",
            ObjectClassInstance.PROTOTYPE,
            Utils.listOf(ObjectClassInstance.OBJECT_TYPE)
    ) {
        @Override
        public int createClass(int caller, int[] args) {
            try {
                return NumberClassInstance.get(Integer.parseInt(PostVMClassInstance.instances.get(args[0]).toString(caller)));
            }catch (NumberFormatException exception) {
                throw new LCLangRuntimeException("Invalid number format", exception.getMessage(), caller);
            }
        }

        @Override
        public Integer loadMethod(String target) {
            switch (target) {
                case "equals": return method(
                        BoolClassInstance.type,
                        (inst, caller, args) -> {
                            PostVMClassInstance another = args[0];
                            return BoolClassInstance.get(
                                    another.prototype.canCast(NumberClassInstance.PROTOTYPE) &&
                                            Objects.equals(((NumberClassInstance) another).value,
                                                    inst.value)
                            );

                        },
                        ObjectClassInstance.OBJECT_TYPE
                );
            }

            return super.loadMethod(target);
        }

        @Override
        public String toString(NumberClassInstance inst, int caller) {
            return String.valueOf(inst.value);
        }
    };

    public static final Type TYPE = PROTOTYPE.type;
    public final Number value;

    private NumberClassInstance(Number value) {
        super(Caller.CALLER_NONE, PROTOTYPE);
        this.value = value;
    }

    public int add(NumberClassInstance another) {
        if (value instanceof Double || another.value instanceof Double)
            return NumberClassInstance.get(value.doubleValue() + another.value.doubleValue());
        else if (value instanceof Long || another.value instanceof Long)
            return NumberClassInstance.get(value.longValue() + another.value.longValue());

        return NumberClassInstance.get(value.intValue() + another.value.intValue());
    }

    public int minus(NumberClassInstance another) {
        if (value instanceof Double || another.value instanceof Double)
            return NumberClassInstance.get(value.doubleValue() - another.value.doubleValue());
        else if (value instanceof Long || another.value instanceof Long)
            return NumberClassInstance.get(value.longValue() - another.value.longValue());

        return NumberClassInstance.get(value.intValue() - another.value.intValue());
    }

    public int multiplication(NumberClassInstance another) {
        if (value instanceof Double || another.value instanceof Double)
            return NumberClassInstance.get(value.doubleValue() * another.value.doubleValue());
        else if (value instanceof Long || another.value instanceof Long)
            return NumberClassInstance.get(value.longValue() * another.value.longValue());

        return NumberClassInstance.get(value.intValue() * another.value.intValue());
    }

    public int binaryOr(NumberClassInstance another) {
        if (value instanceof Long || another.value instanceof Long)
            return NumberClassInstance.get(value.longValue() | another.value.longValue());

        return NumberClassInstance.get(value.intValue() | another.value.intValue());
    }

    public int binaryAnd(NumberClassInstance another) {
        if (value instanceof Long || another.value instanceof Long)
            return NumberClassInstance.get(value.longValue() & another.value.longValue());

        return NumberClassInstance.get(value.intValue() & another.value.intValue());
    }

    public int binaryLeftShift(NumberClassInstance another) {
        if (value instanceof Long || another.value instanceof Long)
            return NumberClassInstance.get(value.longValue() << another.value.longValue());

        return NumberClassInstance.get(value.intValue() << another.value.intValue());
    }

    public int binaryRightShift(NumberClassInstance another) {
        if (value instanceof Long || another.value instanceof Long)
            return NumberClassInstance.get(value.longValue() >> another.value.longValue());

        return NumberClassInstance.get(value.intValue() >> another.value.intValue());
    }


    public int binaryXOr(NumberClassInstance another) {
        if (value instanceof Long || another.value instanceof Long)
            return NumberClassInstance.get(value.longValue() ^ another.value.longValue());

        return NumberClassInstance.get(value.intValue() ^ another.value.intValue());
    }

    public int div(NumberClassInstance another) {
        return NumberClassInstance.get(value.doubleValue() / another.value.doubleValue());
    }

    public int pow(NumberClassInstance another) {
        return NumberClassInstance.get(Math.pow(value.doubleValue(), another.value.doubleValue()));
    }

    public int larger(NumberClassInstance another) {
        return BoolClassInstance.get(value.doubleValue()>another.value.doubleValue());
    }

    public int largerEquals(NumberClassInstance another) {
        return BoolClassInstance.get(value.doubleValue()>=another.value.doubleValue());
    }

    public int less(NumberClassInstance another) {
        return BoolClassInstance.get(value.doubleValue()<another.value.doubleValue());
    }

    public int lessEquals(NumberClassInstance another) {
        return BoolClassInstance.get(value.doubleValue()<=another.value.doubleValue());
    }

    public int compliment() {
        if(value instanceof Long)
            return NumberClassInstance.get(~value.longValue());

        return NumberClassInstance.get(~value.intValue());
    }

    public static int get(Number value) {
        if(CacheManager.cashedClasses.containsKey(value))
            return CacheManager.cashedClasses.get(value);

        NumberClassInstance NumberClass = new NumberClassInstance(value);
        CacheManager.saveCache(value, NumberClass.classId);
        return NumberClass.classId;
    }
}
