package postvm.library.classes;

import postvm.Caller;
import postvm.exceptions.LCLangRuntimeException;
import postvm.library.classes.numbers.IntClass;
import postvm.library.classes.numbers.NumberClass;
import postvm.methods.Method;
import postvm.types.CallableType;
import postvm.types.Type;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class ArrayClass extends LibraryClass {
    public static final String name = "array";
    public static final ArrayClass INSTANCE = new ArrayClass();
    public static final Type type = INSTANCE.classType;

    public List<PostVMClass> value;
    private ArrayClass() {
        super(name);
    }

    public PostVMClass get(int index) {
        return value.size() > index && index >= 0 ?
                value.get(index)
                : NullClass.INSTANCE;
    }

    public void add(PostVMClass clazz) {
        value.add(clazz);
    }
    public PostVMClass last() {
        return get(value.size()-1);
    }
    public ArrayClass merge(ArrayClass array) {
        List<PostVMClass> items = new ArrayList<>(this.value);
        items.addAll(array.value);

        return new ArrayClass(items);
    }

    public ArrayClass(List<PostVMClass> list) {
        super(name);
        value = list;
    }

    @Override
    public PostVMClass loadGlobal(String target) {
        switch (target) {
            case "add": return voidMethod((caller, args) -> add(args.get(0)), PostVMClass.OBJECT_TYPE);
            case "get": return method((caller, args) -> get(args.get(0).cast(IntClass.class).value),
                    IntClass.TYPE, PostVMClass.OBJECT_TYPE);
            case "size": return method((caller, args) -> IntClass.get(value.size()), IntClass.TYPE);
            case "last": return method((caller, args) -> last(), PostVMClass.OBJECT_TYPE);
            case "remove": return method((caller, args) -> BoolClass.get(value.remove(args.get(0))),
                    PostVMClass.OBJECT_TYPE, BoolClass.type);
            case "removeAt": return method((caller, args) -> value.remove(args.get(0).cast(NumberClass.class)
                            .value.intValue()),
                    IntClass.TYPE, PostVMClass.OBJECT_TYPE);
            case "join": return method((caller, args) ->
                            StringClass.get(join(caller, ((StringClass) args.get(0)).string)),
                    StringClass.type, StringClass.type);
            case "toString": return method((caller, args) ->
                            StringClass.get("["+join(caller, ", ")+"]"),
                    StringClass.type);

            case "find": return method((caller, args) -> {
                Method method = (Method) args.get(0);
                for (PostVMClass item: value) {
                    if(method.call(caller, Collections.singletonList(item))==BoolClass.TRUE){
                        return item;
                    }
                }

                return NullClass.INSTANCE;
            }, CallableType.get(PostVMClass.OBJECT_TYPE, BoolClass.type), PostVMClass.OBJECT_TYPE);

            case "forEach": return voidMethod((caller, args) -> {
                Method method = (Method) args.get(0);
                for (PostVMClass item: value) {
                    method.call(caller, Collections.singletonList(item));
                }
            }, CallableType.get(PostVMClass.OBJECT_TYPE, VoidClass.type));
        }

        return super.loadGlobal(target);
    }

    public String join(Caller caller, String delimiter) throws LCLangRuntimeException {
        List<String> items = new ArrayList<>();
        for(PostVMClass item: value)
            items.add(item.toString(caller));

        return String.join(delimiter, items);
    }
}
