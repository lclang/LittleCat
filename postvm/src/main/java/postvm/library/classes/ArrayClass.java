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
import java.util.stream.Collectors;

public final class ArrayClass extends LibraryClass {
    public static final PostVMClassPrototype PROTOTYPE = new PostVMClassPrototype(
            "array",
            ObjectClass.PROTOTYPE,
            Collections.emptyList()
    ) {
        @Override
        public int createClass(Caller caller, int[] args) {
            return new ArrayClass(args).classId;
        }
    };

    public static final Type type = PROTOTYPE.type;

    public int[] value;

    public int get(int index) {
        return value.length > index && index >= 0 ?
                value[index]
                : VoidClass.INSTANCE.classId;
    }

    public void add(int clazz) {
        int[] oldValue = value;
        value = new int[oldValue.length+1];
        System.arraycopy(oldValue, 0, value, 0, oldValue.length);
        value[value.length-1] = clazz;
    }

    public int removeAt(int index) {
        final int length = value.length;
        if (index < 0 || index >= length) {
            return -1;
        }

        int object = value[index];
        final int[] result = new int[length-1];
        System.arraycopy(value, 0, result, 0, index);
        if (index < length - 1) {
            System.arraycopy(value, index + 1, result, index, length - index - 1);
        }
        value = result;
        return object;
    }

    public int indexOf(final int valueToFind) {
        if (value.length==0) {
            return -1;
        }

        for (int i = 0; i < value.length; i++) {
            if (valueToFind == value[i]) {
                return i;
            }
        }

        return -1;
    }

    public Integer last() {
        if(value.length==0) return VoidClass.INSTANCE.classId;

        return get(value.length-1);
    }

    public ArrayClass merge(ArrayClass array) {
        int[] result = new int[value.length + array.value.length];
        System.arraycopy(value, 0, result, 0, value.length);
        System.arraycopy(array.value, 0, result, value.length, array.value.length);

        return new ArrayClass(result);
    }

    public ArrayClass(int[] list) {
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
            case "size": return method(NumberClass.TYPE, (caller, args) -> NumberClass.get(value.length));
            case "last": return method(ObjectClass.OBJECT_TYPE, (caller, args) -> last());
            case "remove": return nativeMethod(BoolClass.type, (caller, args) -> BoolClass.get(removeAt(indexOf(args[0]))!=-1),
                    ObjectClass.OBJECT_TYPE);
            case "removeAt": return method(ObjectClass.OBJECT_TYPE, (caller, args) -> removeAt(args[0].cast(NumberClass.class).value.intValue()), NumberClass.TYPE);
            case "join": return method(StringClass.type, (caller, args) ->
                            StringClass.get(join(caller, ((StringClass) args[0]).string)),
                    StringClass.type);
            case "toString": return toStrMethod((caller) -> StringClass.get("["+join(caller, ", ")+"]"));

            case "find": return method(ObjectClass.OBJECT_TYPE, (caller, args) -> {
                Method method = (Method) args[0];
                for (int item: value) {
                    if(method.call(caller, new int[]{item})==BoolClass.TRUE){
                        return item;
                    }
                }

                return NullClass.INSTANCE.classId;
            }, CallableType.get(ObjectClass.OBJECT_TYPE, BoolClass.type));

            case "filter": return method(ObjectClass.OBJECT_TYPE, (caller, args) -> {
                Method method = (Method) args[0];

                ArrayClass arrayClass = new ArrayClass(new int[0]);
                for (int item: value) {
                    if(method.call(caller, new int[]{item})==BoolClass.TRUE){
                        arrayClass.add(item);
                    }
                }

                return arrayClass.classId;
            }, CallableType.get(ObjectClass.OBJECT_TYPE, BoolClass.type));

            case "forEach": return voidMethod((caller, args) -> {
                Method method = (Method) args[0];
                for (int item: value) {
                    method.call(caller, new int[]{item});
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
