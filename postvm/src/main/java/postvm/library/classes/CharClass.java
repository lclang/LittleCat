package postvm.library.classes;

import postvm.CacheManager;
import postvm.Caller;
import postvm.Utils;
import postvm.library.classes.numbers.IntClass;
import postvm.library.classes.numbers.NumberClass;
import postvm.types.Type;

import java.util.List;
import java.util.Objects;

public final class CharClass extends LibraryClass {
    public static final PostVMClassPrototype PROTOTYPE = new PostVMClassPrototype(
            "char",
            PostVMClass.PROTOTYPE,
            Utils.listOf(IntClass.TYPE)
    ) {
        @Override
        public PostVMClass createClass(Caller caller, List<PostVMClass> args) {
            return CharClass.get((char) args.get(0).cast(NumberClass.class)
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
    public PostVMClass loadGlobal(String target) {
        switch (target) {
            case "toString": return method((caller, lcClasses) -> StringClass.get(String.valueOf(value)),
                    StringClass.type);
            case "toInt": return method((caller, lcClasses) -> IntClass.get(value),
                    IntClass.TYPE);
            case "upper": return method((caller, lcClasses) -> CharClass.get(Character.toUpperCase(value)),
                    type);
            case "lower": return method((caller, lcClasses) -> CharClass.get(Character.toLowerCase(value)),
                    type);
            case "equals": return method((caller, args) -> {
                PostVMClass clazz = args.get(0);

                return BoolClass.get(clazz.prototype.canCast(CharClass.PROTOTYPE) &&
                        Objects.equals(clazz.cast(CharClass.class).value, value));
            }, PostVMClass.OBJECT_TYPE, BoolClass.type);
        }
        return super.loadGlobal(target);
    }

    public static CharClass get(char value) {
        if(CacheManager.cashedClasses.containsKey(value))
            return (CharClass) CacheManager.cashedClasses.get(value);

        CharClass clazz = new CharClass(value);
        CacheManager.saveCache(value, clazz);
        return clazz;
    }
}
