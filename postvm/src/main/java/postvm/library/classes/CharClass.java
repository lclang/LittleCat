package postvm.library.classes;

import postvm.CacheManager;
import postvm.library.classes.numbers.IntClass;
import postvm.library.classes.numbers.NumberClass;
import postvm.types.Type;

public final class CharClass extends LibraryClass {
    public static final String name =  "char";
    public static final CharClass INSTANCE = new CharClass();
    public static final Type type = INSTANCE.classType;
    public char value;

    private CharClass() {
        super(name);
        constructor = method((caller, args) -> CharClass.get((char) args.get(0).cast(NumberClass.class).value.intValue()),
                IntClass.TYPE);
    }

    private CharClass(char value) {
        this();
        this.value = value;
        globals.put("toString", method((caller, lcClasses) -> StringClass.get(String.valueOf(value)),
                StringClass.type));
        globals.put("toInt", method((caller, lcClasses) -> IntClass.get(value),
                IntClass.TYPE));
        globals.put("upper", method((caller, lcClasses) -> CharClass.get(Character.toUpperCase(value)),
                type));
        globals.put("lower", method((caller, lcClasses) -> CharClass.get(Character.toLowerCase(value)),
                type));
    }

    public static CharClass get(char value) {
        if(CacheManager.cashedClasses.containsKey(value))
            return (CharClass) CacheManager.cashedClasses.get(value);

        CharClass clazz = new CharClass(value);
        CacheManager.saveCache(value, clazz);
        return clazz;
    }
}
