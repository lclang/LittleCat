package postvm.library.classes;

import postvm.CacheManager;
import postvm.Caller;
import postvm.Utils;
import postvm.library.classes.numbers.NumberClass;
import postvm.types.Type;

import java.util.Objects;

public final class CharClass extends LibraryClass {
    public static final PostVMClassPrototype PROTOTYPE = new PostVMClassPrototype(
            "char",
            ObjectClass.PROTOTYPE,
            Utils.listOf(NumberClass.TYPE)
    ) {
        @Override
        public int createClass(Caller caller, int[] args) {
            return CharClass.get((char) PostVMClass.instances.get(args[0]).cast(NumberClass.class)
                    .value.intValue());
        }
    };

    public static final Type type = PROTOTYPE.type;
    public char value;

    private CharClass(char value) {
        super(null, PROTOTYPE);
        this.value = value;
    }

    @Override
    public Integer loadGlobal(PostVMClass clazz, String target) {
        switch (target) {
            case "toString": return toStrMethod((caller) -> StringClass.get(String.valueOf(value)));
            case "toInt": return method(NumberClass.TYPE, (caller, lcClasses) -> NumberClass.get((int) value));
            case "upper": return method(type, (caller, lcClasses) -> CharClass.get(Character.toUpperCase(value)));
            case "lower": return method(type, (caller, lcClasses) -> CharClass.get(Character.toLowerCase(value)));
            case "equals": return method(BoolClass.type, (caller, args) -> {
                PostVMClass arg = args[0];

                return BoolClass.get(arg.prototype.canCast(CharClass.PROTOTYPE) &&
                        Objects.equals(arg.cast(CharClass.class).value, value));
            }, ObjectClass.OBJECT_TYPE);
        }
        return super.loadGlobal(clazz, target);
    }

    public static int get(char value) {
        if(CacheManager.cashedClasses.containsKey(value))
            return CacheManager.cashedClasses.get(value);

        CharClass clazz = new CharClass(value);
        CacheManager.saveCache(value, clazz.classId);
        return clazz.classId;
    }
}
