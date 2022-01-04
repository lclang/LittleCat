package postvm.library.classes;

import postvm.CacheManager;
import postvm.library.classes.numbers.IntClass;
import postvm.types.Type;

import java.util.ArrayList;
import java.util.List;

public final class StringClass extends LibraryClass {
    public static final String name = "string";
    public static final StringClass INSTANCE = new StringClass();
    public static final Type type = INSTANCE.classType;
    public String string;

    private StringClass() {
        super(name);
        constructor = method((caller, args) -> get(args.get(0).toString(caller)), OBJECT_TYPE, type);
    }

    private StringClass(String string) {
        this();
        this.string = string;
        globals.put("toString", method((caller, lcClasses) -> this, type));
        globals.put("length", IntClass.get(string.length()));
        globals.put("charAt", method((caller, args) -> CharClass.get(string.charAt(args.get(0).cast(IntClass.class)
                        .value.intValue())),
            IntClass.TYPE, CharClass.type));
        globals.put("toArray", method((caller, lcClasses) -> {
            List<PostVMClass> classes = new ArrayList<>();

            char[] chars = string.toCharArray();
            for (char character: chars)
                classes.add(CharClass.get(character));

            return new ArrayClass(classes);
        }, ArrayClass.type));

        globals.put("lower", method((caller, args) -> StringClass.get(string.toLowerCase()), type));
        globals.put("upper", method((caller, args) -> StringClass.get(string.toUpperCase()), type));

        globals.put("split", method((caller, args) -> {
            List<PostVMClass> classes = new ArrayList<>();
            String[] parts = string.split(args.get(0).cast(StringClass.class).string);
            for (String part: parts)
                classes.add(StringClass.get(part));

            return new ArrayClass(classes);
        }, type, type));

        globals.put("substring", method((caller, args) ->
                        StringClass.get(
                            string.substring(
                                    args.get(0).cast(IntClass.class).value.intValue(),
                                    args.get(1).cast(IntClass.class).value.intValue()
                            )
                        ),
                IntClass.TYPE, IntClass.TYPE, type));

        globals.put("find", method((caller, args) ->
                        IntClass.get(string.indexOf(args.get(0).cast(CharClass.class).value)),
                CharClass.type, type));

        globals.put("findLast", method((caller, args) ->
                        IntClass.get(string.lastIndexOf(args.get(0).cast(CharClass.class).value)),
                CharClass.type, type));
    }

    public static StringClass get(String string) {
        if(CacheManager.cashedClasses.containsKey(string))
            return (StringClass) CacheManager.cashedClasses.get(string);

        StringClass clazz = new StringClass(string);
        CacheManager.saveCache(string, clazz);
        return clazz;
    }
}
