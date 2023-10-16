package postvm.library.classes;

import postvm.CacheManager;
import postvm.Caller;
import postvm.Utils;
import postvm.classes.PostVMClassInstance;
import postvm.classes.PostVMClassPrototype;
import postvm.types.Type;

import java.util.Objects;

public final class CharClassInstance extends LibraryClassInstance {
    public static final PostVMClassPrototype PROTOTYPE = new PostVMClassPrototype(
            "char",
            ObjectClassInstance.PROTOTYPE,
            Utils.listOf(NumberClassInstance.TYPE)
    ) {
        @Override
        public int createClass(int caller, int[] args) {
            return CharClassInstance.get((char) PostVMClassInstance.instances.get(args[0]).cast(NumberClassInstance.class)
                    .value.intValue());
        }
    };

    public static final Type type = PROTOTYPE.type;
    public char value;

    private CharClassInstance(char value) {
        super(Caller.CALLER_NONE, PROTOTYPE);
        this.value = value;
    }

    @Override
    public Integer loadMethod(PostVMClassInstance clazz, String target) {
        switch (target) {
            case "toString": return toStrMethod((caller) -> StringClassInstance.get(String.valueOf(value)));
            case "toInt": return method(NumberClassInstance.TYPE, (caller, lcClasses) -> NumberClassInstance.get((int) value));
            case "upper": return method(type, (caller, lcClasses) -> CharClassInstance.get(Character.toUpperCase(value)));
            case "lower": return method(type, (caller, lcClasses) -> CharClassInstance.get(Character.toLowerCase(value)));
            case "equals": return method(BoolClassInstance.type, (caller, args) -> {
                PostVMClassInstance arg = args[0];

                return BoolClassInstance.get(arg.prototype.canCast(CharClassInstance.PROTOTYPE) &&
                        Objects.equals(arg.cast(CharClassInstance.class).value, value));
            }, ObjectClassInstance.OBJECT_TYPE);
        }
        return super.loadMethod(clazz, target);
    }

    public static int get(char value) {
        if(CacheManager.cashedClasses.containsKey(value))
            return CacheManager.cashedClasses.get(value);

        CharClassInstance clazz = new CharClassInstance(value);
        CacheManager.saveCache(value, clazz.classId);
        return clazz.classId;
    }
}
