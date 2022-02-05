package postvm.library.classes;

import postvm.CacheManager;
import postvm.Caller;
import postvm.Utils;
import postvm.library.classes.numbers.IntClass;
import postvm.types.Type;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class StringClass extends LibraryClass {
    public static final PostVMClassPrototype PROTOTYPE = new PostVMClassPrototype(
            "string",
            PostVMClass.PROTOTYPE,
            Utils.listOf(PostVMClass.PROTOTYPE.type)
    ) {
        @Override
        public PostVMClass createClass(Caller caller, List<PostVMClass> args) {
            return get(args.get(0).toString(caller));
        }
    };

    public static final Type type = PROTOTYPE.type;
    public String string;

    private StringClass(String string) {
        super(null, PROTOTYPE);
        this.string = string;
    }

    @Override
    public PostVMClass loadGlobal(String target) {
        switch (target) {
            case "toString": return method((caller, lcClasses) -> this, type);
            case "length": return IntClass.get(string.length());
            case "charAt": return method((caller, args) -> CharClass.get(
                    string.charAt(args.get(0).cast(IntClass.class).value)),
                    IntClass.TYPE, CharClass.type);
            case "equals": return method((caller, args) -> {
                PostVMClass clazz = args.get(0);

                return BoolClass.get(clazz.prototype.canCast(StringClass.PROTOTYPE) &&
                        Objects.equals(clazz.cast(StringClass.class).string, string));
            }, PostVMClass.OBJECT_TYPE, BoolClass.type);
            case "toArray": return method((caller, lcClasses) -> {
                List<PostVMClass> classes = new ArrayList<>();

                char[] chars = string.toCharArray();
                for (char character: chars)
                    classes.add(CharClass.get(character));

                return new ArrayClass(classes);
            }, ArrayClass.type);
            case "lower": return method((caller, args) -> StringClass.get(string.toLowerCase()), type);
            case "upper": return method((caller, args) -> StringClass.get(string.toUpperCase()), type);
            case "endsWith": return method((caller, args) -> BoolClass.get(string.endsWith(args.get(0)
                    .cast(StringClass.class).string)), type, BoolClass.type);
            case "startsWith": return method((caller, args) -> BoolClass.get(string.startsWith(args.get(0)
                    .cast(StringClass.class).string)), type, BoolClass.type);
            case "split": return method((caller, args) -> {
                List<PostVMClass> classes = new ArrayList<>();
                String[] parts = string.split(args.get(0).cast(StringClass.class).string);
                for (String part: parts)
                    classes.add(StringClass.get(part));

                return new ArrayClass(classes);
            }, type, type);
            case "substring": return method((caller, args) ->
                            StringClass.get(
                                    string.substring(
                                            args.get(0).cast(IntClass.class).value,
                                            args.get(1).cast(IntClass.class).value
                                    )
                            ),
                    IntClass.TYPE, IntClass.TYPE, type);
            case "find": return method((caller, args) ->
                            IntClass.get(string.indexOf(args.get(0).cast(CharClass.class).value)),
                    CharClass.type, type);
            case "findLast": return method((caller, args) ->
                            IntClass.get(string.lastIndexOf(args.get(0).cast(CharClass.class).value)),
                    CharClass.type, type);
        }

        return super.loadGlobal(target);
    }

    public static StringClass get(String string) {
        if(CacheManager.cashedClasses.containsKey(string))
            return (StringClass) CacheManager.cashedClasses.get(string);

        StringClass clazz = new StringClass(string);
        CacheManager.saveCache(string, clazz);
        return clazz;
    }
}
