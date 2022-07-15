package postvm.library.classes;

import postvm.Caller;
import postvm.exceptions.LCLangRuntimeException;
import postvm.library.classes.numbers.NumberClass;
import postvm.methods.Method;
import postvm.types.CallableType;
import postvm.types.Type;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class ArrayClass extends LibraryClass {
    public static final PostVMClassPrototype PROTOTYPE = new PostVMClassPrototype(
            "array",
            ObjectClass.PROTOTYPE,
            Collections.emptyList()
    ) {
        @Override
        public int createClass(Caller caller, Integer[] args) {
            return new ArrayClass(Arrays.asList(args)).classId;
        }
    };

    public static final Type type = PROTOTYPE.type;

    public List<Integer> value;

    public Integer get(int index) {
        return value.size() > index && index >= 0 ?
                value.get(index)
                : VoidClass.INSTANCE.classId;
    }

    public void add(Integer clazz) {
        value.add(clazz);
    }
    public Integer last() {
        if(value.size()==0) return VoidClass.INSTANCE.classId;

        return get(value.size()-1);
    }
    public ArrayClass merge(ArrayClass array) {
        List<Integer> items = new ArrayList<>(this.value);
        items.addAll(array.value);

        return new ArrayClass(items);
    }

    public ArrayClass(List<Integer> list) {
        super(null, PROTOTYPE);
        value = list;
    }

    @Override
    public Integer loadGlobal(PostVMClass clazz, String target) {
        switch (target) {
            case "add": return voidMethod((caller, args) -> add(args[0].classId), ObjectClass.OBJECT_TYPE);
            case "get": return method(ObjectClass.OBJECT_TYPE,
                    (caller, args) -> get(args[0].cast(NumberClass.class).value.intValue()),
                    NumberClass.TYPE);
            case "size": return method(NumberClass.TYPE, (caller, args) -> NumberClass.get(value.size()));
            case "last": return method(ObjectClass.OBJECT_TYPE, (caller, args) -> last());
            case "remove": return nativeMethod(BoolClass.type, (caller, args) -> BoolClass.get(value.remove(args[0])),
                    ObjectClass.OBJECT_TYPE);
            case "removeAt": return method(ObjectClass.OBJECT_TYPE, (caller, args) -> value.remove(args[0].cast(NumberClass.class)
                            .value.intValue()), NumberClass.TYPE);
            case "join": return method(StringClass.type, (caller, args) ->
                            StringClass.get(join(caller, ((StringClass) args[0]).string)),
                    StringClass.type);
            case "toString": return toStrMethod((caller) -> StringClass.get("["+join(caller, ", ")+"]"));

            case "find": return method(ObjectClass.OBJECT_TYPE, (caller, args) -> {
                Method method = (Method) args[0];
                for (int item: value) {
                    if(method.call(caller, new Integer[]{item})==BoolClass.TRUE){
                        return item;
                    }
                }

                return NullClass.INSTANCE.classId;
            }, CallableType.get(ObjectClass.OBJECT_TYPE, BoolClass.type));

            case "forEach": return voidMethod((caller, args) -> {
                Method method = (Method) args[0];
                for (int item: value) {
                    method.call(caller, new Integer[]{item});
                }
            }, CallableType.get(ObjectClass.OBJECT_TYPE, VoidClass.PROTOTYPE.type));
        }

        return super.loadGlobal(clazz, target);
    }

    public String join(Caller caller, String delimiter) throws LCLangRuntimeException {
        List<String> items = new ArrayList<>();
        for(int item: value)
            items.add(PostVMClass.instances.get(item).toString(caller));

        return String.join(delimiter, items);
    }
}
