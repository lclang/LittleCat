package postvm.library.classes;

import postvm.Caller;
import postvm.classes.PostVMClassInstance;
import postvm.classes.PostVMClassPrototype;
import postvm.exceptions.LCLangRuntimeException;
import postvm.methods.MethodInstance;
import postvm.types.CallableType;
import postvm.types.Type;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public final class ArrayClassInstance extends LibraryClassInstance {
    public static final PostVMClassPrototype<ArrayClassInstance> PROTOTYPE = new PostVMClassPrototype<ArrayClassInstance>(
            "array",
            ObjectClassInstance.PROTOTYPE,
            Collections.emptyList()
    ) {
        @Override
        public int createClass(int caller, int[] args) {
            return new ArrayClassInstance(Arrays.stream(args).boxed().collect(Collectors.toList())).classId;
        }

        @Override
        public MethodInstance loadMethod(String target) {
            switch (target) {
                case "add":
                    return voidMethod(
                            (inst, caller, args) -> inst.add(args[0].classId),
                            ObjectClassInstance.OBJECT_TYPE
                    );

                case "get":
                    return method(
                            ObjectClassInstance.OBJECT_TYPE,
                            (inst, caller, args) -> inst.get(args[0].cast(NumberClassInstance.class).value.intValue()),
                            NumberClassInstance.TYPE
                    );

                case "size":
                    return method(NumberClassInstance.TYPE,
                            (inst, caller, args) -> NumberClassInstance.get(inst.value.size())
                    );

                case "last":
                    return method(
                            ObjectClassInstance.OBJECT_TYPE,
                            (inst, caller, args) -> inst.last()
                    );

                case "remove":
                    return nativeArgsMethod(
                            BoolClassInstance.type,
                            (inst, caller, args) ->
                                    BoolClassInstance.get(inst.value.remove(args[0])),
                            ObjectClassInstance.OBJECT_TYPE
                    );

                case "removeAt":
                    return method(
                            ObjectClassInstance.OBJECT_TYPE,
                            (inst, caller, args) -> inst.value.remove(args[0].cast(NumberClassInstance.class).value.intValue()),
                            NumberClassInstance.TYPE
                    );

                case "join":
                    return method(
                            StringClassInstance.type,
                            (inst, caller, args) ->
                                    StringClassInstance.get(inst.join(caller, ((StringClassInstance) args[0]).string)),
                            StringClassInstance.type
                    );

                case "find":
                    return method(
                            ObjectClassInstance.OBJECT_TYPE,
                            (inst, caller, args) -> {
                                MethodInstance method = (MethodInstance) args[0];
                                for (int item : inst.value) {
                                    if (method.call(MethodInstance.NO_INSTANCE, caller, new int[]{item}) == BoolClassInstance.TRUE) {
                                        return item;
                                    }
                                }

                                return NullClassInstance.INSTANCE.classId;
                            },
                            CallableType.get(
                                    ObjectClassInstance.OBJECT_TYPE,
                                    BoolClassInstance.type
                            )
                    );

                case "filter":
                    return method(
                            ObjectClassInstance.OBJECT_TYPE,
                            (inst, caller, args) -> {
                                MethodInstance method = (MethodInstance) args[0];
                                List<Integer> filteredList = new ArrayList<>();
                                for (int item : inst.value) {
                                    if (method.call(MethodInstance.NO_INSTANCE, caller, new int[]{item}) == BoolClassInstance.TRUE) {
                                        filteredList.add(item);
                                    }
                                }

                                return new ArrayClassInstance(filteredList).classId;
                            },
                            CallableType.get(
                                    ObjectClassInstance.OBJECT_TYPE,
                                    BoolClassInstance.type
                            )
                    );

                case "forEach":
                    return voidMethod(
                            (inst, caller, args) -> {
                                MethodInstance method = (MethodInstance) args[0];
                                for (int item : inst.value) {
                                    method.call(MethodInstance.NO_INSTANCE, caller, new int[]{item});
                                }
                            },
                            CallableType.get(
                                    ObjectClassInstance.OBJECT_TYPE,
                                    VoidClassInstance.PROTOTYPE.type
                            )
                    );
            }

            return super.loadMethod(target);
        }

        @Override
        public String toString(ArrayClassInstance inst, int caller) {
            return "[" + inst.join(caller, ", ") + "]";
        }
    };

    public static final Type type = PROTOTYPE.type;

    public List<Integer> value;

    public Integer get(int index) {
        return value.size() > index && index >= 0 ?
                value.get(index)
                : VoidClassInstance.INSTANCE.classId;
    }

    public void add(Integer clazz) {
        value.add(clazz);
    }

    public Integer last() {
        if (value.isEmpty()) return VoidClassInstance.INSTANCE.classId;

        return get(value.size() - 1);
    }

    public ArrayClassInstance merge(ArrayClassInstance array) {
        List<Integer> items = new ArrayList<>(this.value);
        items.addAll(array.value);

        return new ArrayClassInstance(items);
    }

    public ArrayClassInstance(List<Integer> list) {
        super(Caller.CALLER_NONE, PROTOTYPE);
        value = list;
    }

    public String join(int caller, String delimiter) throws LCLangRuntimeException {
        List<String> items = new ArrayList<>();
        for (int item : value)
            items.add(PostVMClassInstance.instances.get(item).toString(caller));

        return String.join(delimiter, items);
    }
}
