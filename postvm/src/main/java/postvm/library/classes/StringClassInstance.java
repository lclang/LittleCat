package postvm.library.classes;

import postvm.CacheManager;
import postvm.Caller;
import postvm.Utils;
import postvm.classes.PostVMClassInstance;
import postvm.classes.PostVMClassPrototype;
import postvm.types.Type;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class StringClassInstance extends LibraryClassInstance {
    public static final PostVMClassPrototype<StringClassInstance> PROTOTYPE = new PostVMClassPrototype<StringClassInstance>(
            "string",
            ObjectClassInstance.PROTOTYPE,
            Utils.listOf(ObjectClassInstance.PROTOTYPE.type)
    ) {
        @Override
        public int createClass(int caller, int[] args) {
            return get(PostVMClassInstance.instances.get(args[0]).toString(caller));
        }

        @Override
        public String toString(StringClassInstance inst, int caller) {
            return inst.string;
        }

        @Override
        public Integer loadMethod(String target) {
            switch (target) {
                case "charAt": return method(
                        CharClassInstance.type,
                        (inst, caller, args) -> CharClassInstance.get(
                                inst.string.charAt(args[0].cast(NumberClassInstance.class).value.intValue())
                        ),
                        NumberClassInstance.TYPE
                );
                case "equals": return method(
                        BoolClassInstance.type,
                        (inst, caller, args) -> {
                            PostVMClassInstance arg = args[0];

                            return BoolClassInstance.get(arg.prototype.canCast(StringClassInstance.PROTOTYPE) &&
                                    Objects.equals(arg.cast(StringClassInstance.class).string, inst.string));
                        },
                        ObjectClassInstance.OBJECT_TYPE
                );
                case "toArray": return method(
                        ArrayClassInstance.type,
                        (inst, caller, lcClasses) -> {
                            List<Integer> classes = new ArrayList<>();

                            char[] chars = inst.string.toCharArray();
                            for (char character: chars)
                                classes.add(CharClassInstance.get(character));

                            return new ArrayClassInstance(classes).classId;
                        }
                );
                case "lower": return method(type, (inst, caller, args) ->
                        StringClassInstance.get(inst.string.toLowerCase())
                );

                case "upper": return method(type, (inst, caller, args) ->
                        StringClassInstance.get(inst.string.toUpperCase())
                );

                case "endsWith": return method(
                        BoolClassInstance.type,
                        (inst, caller, args) ->
                                BoolClassInstance.get(
                                        inst.string.endsWith(args[0].cast(StringClassInstance.class).string)
                                ),
                        type
                );
                case "startsWith": return method(
                        BoolClassInstance.type,
                        (inst, caller, args) ->
                                BoolClassInstance.get(
                                        inst.string.startsWith(args[0]
                                            .cast(StringClassInstance.class).string)
                                ),
                        type
                );

                case "split": return method(type, (inst, caller, args) -> {
                    List<Integer> classes = new ArrayList<>();
                    String[] parts = inst.string.split(args[0].cast(StringClassInstance.class).string);
                    for (String part: parts)
                        classes.add(StringClassInstance.get(part));

                    return new ArrayClassInstance(classes).classId;
                }, type);
                case "substring": return method(type, (inst, caller, args) ->
                                StringClassInstance.get(
                                        inst.string.substring(
                                                args[0].cast(NumberClassInstance.class).value.intValue(),
                                                args[1].cast(NumberClassInstance.class).value.intValue()
                                        )
                                ),
                        NumberClassInstance.TYPE, NumberClassInstance.TYPE);
                case "find": return method(type, (inst, caller, args) ->
                                NumberClassInstance.get(inst.string.indexOf(args[0].cast(CharClassInstance.class).value)),
                        CharClassInstance.type);
                case "findLast": return method(type, (inst, caller, args) ->
                                NumberClassInstance.get(inst.string.lastIndexOf(args[0].cast(CharClassInstance.class).value)),
                        CharClassInstance.type);
            }

            return super.loadMethod(target);
        }
    };

    public static final Type type = PROTOTYPE.type;
    public String string;

    private StringClassInstance(String string) {
        super(Caller.CALLER_NONE, PROTOTYPE);
        this.string = string;
        executor.variables.put("length", NumberClassInstance.get(string.length()));
    }

    public static int get(String value) {
        if(CacheManager.cashedClasses.containsKey(value))
            return CacheManager.cashedClasses.get(value);

        StringClassInstance clazz = new StringClassInstance(value);
        CacheManager.saveCache(value, clazz.classId);
        return clazz.classId;
    }
}
