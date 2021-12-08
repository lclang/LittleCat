package lclang.libs.lang.classes;

import lclang.libs.lang.classes.numbers.IntClass;
import lclang.types.Type;

import java.util.HashMap;
import java.util.Map;

public class CharClass extends LibraryClass {
    public static final String name =  "char";
    public static final Map<Character, CharClass> cache = new HashMap<>();
    public static final CharClass instance = new CharClass();
    public static final Type type = instance.classType;
    public char value;

    private CharClass() {
        super(name);
        constructor = method((caller, args) -> CharClass.get((char) ((IntClass)args.get(0)).value), IntClass.TYPE);
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
        if(cache.containsKey(value))
            return cache.get(value);

        CharClass clazz = new CharClass(value);
        cache.put(value, clazz);
        return clazz;
    }
}
