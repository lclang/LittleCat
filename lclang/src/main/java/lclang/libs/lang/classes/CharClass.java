package lclang.libs.lang.classes;

import lclang.libs.lang.classes.numbers.IntClass;
import lclang.types.Types;

import java.util.HashMap;
import java.util.Map;

public class CharClass extends LibraryClass {
    public static final String name =  "char";
    public static final Types.MagicType type = new Types.MagicType(name);
    public static final Map<Character, CharClass> cache = new HashMap<>();
    public static final CharClass instance = new CharClass();
    public char value;

    private CharClass() {
        super(name);
        constructor = method((caller, args) -> CharClass.get((char) ((IntClass)args.get(0)).value), IntClass.type);
    }

    private CharClass(char value) {
        this();
        this.value = value;
        globals.put("toString", method((caller, lcClasses) -> StringClass.get(String.valueOf(value)),
                StringClass.type).asValue());
        globals.put("toInt", method((caller, lcClasses) -> IntClass.get(value),
                IntClass.type).asValue());
        globals.put("upper", method((caller, lcClasses) -> CharClass.get(Character.toUpperCase(value)),
                type).asValue());
        globals.put("lower", method((caller, lcClasses) -> CharClass.get(Character.toLowerCase(value)),
                type).asValue());
    }

    public static CharClass get(char value) {
        if(cache.containsKey(value))
            return cache.get(value);

        CharClass clazz = new CharClass(value);
        cache.put(value, clazz);
        return clazz;
    }

    public static Types.MagicType getType() {
        return new Types.MagicType(name);
    }
}
