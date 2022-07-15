package postvm.library.classes;

import postvm.CacheManager;
import postvm.Caller;
import postvm.Utils;
import postvm.library.classes.numbers.NumberClass;
import postvm.types.Type;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class StringClass extends LibraryClass {
    public static final PostVMClassPrototype PROTOTYPE = new PostVMClassPrototype(
            "string",
            ObjectClass.PROTOTYPE,
            Utils.listOf(ObjectClass.PROTOTYPE.type)
    ) {
        @Override
        public int createClass(Caller caller, Integer[] args) {
            return get(PostVMClass.instances.get(args[0]).toString(caller));
        }
    };

    public static final Type type = PROTOTYPE.type;
    public String string;

    private StringClass(String string) {
        super(null, PROTOTYPE);
        this.string = string;
    }

    @Override
    public Integer loadGlobal(PostVMClass clazz, String target) {
        switch (target) {
            case "length": return NumberClass.get(string.length());
            case "toString": return method(type, (caller, lcClasses) -> classId);
            case "charAt": return method(CharClass.type, (caller, args) -> CharClass.get(
                    string.charAt(args[0].cast(NumberClass.class).value.intValue())),
                    NumberClass.TYPE);
            case "equals": return method(BoolClass.type, (caller, args) -> {
                PostVMClass arg = args[0];

                return BoolClass.get(arg.prototype.canCast(StringClass.PROTOTYPE) &&
                        Objects.equals(arg.cast(StringClass.class).string, string));
            }, ObjectClass.OBJECT_TYPE);
            case "toArray": return method(ArrayClass.type, (caller, lcClasses) -> {
                List<Integer> classes = new ArrayList<>();

                char[] chars = string.toCharArray();
                for (char character: chars)
                    classes.add(CharClass.get(character));

                return new ArrayClass(classes).classId;
            });
            case "lower": return method(type, (caller, args) -> StringClass.get(string.toLowerCase()));
            case "upper": return method(type, (caller, args) -> StringClass.get(string.toUpperCase()));
            case "endsWith": return method(BoolClass.type, (caller, args) -> BoolClass.get(string.endsWith(args[0]
                    .cast(StringClass.class).string)), type);
            case "startsWith": return method(BoolClass.type, (caller, args) -> BoolClass.get(string.startsWith(args[0]
                    .cast(StringClass.class).string)), type);
            case "split": return method(type, (caller, args) -> {
                List<Integer> classes = new ArrayList<>();
                String[] parts = string.split(args[0].cast(StringClass.class).string);
                for (String part: parts)
                    classes.add(StringClass.get(part));

                return new ArrayClass(classes).classId;
            }, type);
            case "substring": return method(type, (caller, args) ->
                            StringClass.get(
                                    string.substring(
                                            args[0].cast(NumberClass.class).value.intValue(),
                                            args[1].cast(NumberClass.class).value.intValue()
                                    )
                            ),
                    NumberClass.TYPE, NumberClass.TYPE);
            case "find": return method(type, (caller, args) ->
                            NumberClass.get(string.indexOf(args[0].cast(CharClass.class).value)),
                    CharClass.type);
            case "findLast": return method(type, (caller, args) ->
                            NumberClass.get(string.lastIndexOf(args[0].cast(CharClass.class).value)),
                    CharClass.type);
        }

        return super.loadGlobal(clazz, target);
    }

    public static int get(String value) {
        if(CacheManager.cashedClasses.containsKey(value))
            return CacheManager.cashedClasses.get(value);

        StringClass clazz = new StringClass(value);
        CacheManager.saveCache(value, clazz.classId);
        return clazz.classId;
    }
}
