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

public class ArrayClass extends LibraryClass {
    public static final String name = "array";
    public static final ArrayClass instance = new ArrayClass();
    public static final Type type = instance.classType;

    public List<PostVMClass> value;
    private ArrayClass() {
        super(name);
    }

    public PostVMClass get(int index) {
        return value.size() > index && index >= 0 ?
                value.get(index)
                : NullClass.instance;
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
        this();
        value = list;

        globals.put("add", voidMethod((caller, args) -> add(args.get(0)), PostVMClass.OBJECT_TYPE));
        globals.put("size", method((caller, args) -> IntClass.get(value.size()), IntClass.TYPE));
        globals.put("last", method((caller, args) -> last(), PostVMClass.OBJECT_TYPE));
        globals.put("remove", method((caller, args) -> BoolClass.get(list.remove(args.get(0))),
                PostVMClass.OBJECT_TYPE, BoolClass.type));
        globals.put("removeAt", method((caller, args) -> list.remove(args.get(0).cast(NumberClass.class)
                        .value.intValue()),
                IntClass.TYPE, PostVMClass.OBJECT_TYPE));
        globals.put("join", method((caller, args) ->
                        StringClass.get(join(caller, ((StringClass) args.get(0)).string)),
                StringClass.type, StringClass.type));
        globals.put("toString", method((caller, args) ->
                        StringClass.get("["+join(caller, ", ")+"]"),
                StringClass.type));

        globals.put("filter", method((caller, args) -> {
            Method method = (Method) args.get(0);
            for (PostVMClass item: value) {
                if(method.call(caller, Collections.singletonList(item))==BoolClass.TRUE){
                    return item;
                }
            }

            return NullClass.instance;
        }, CallableType.get(PostVMClass.OBJECT_TYPE, BoolClass.type), PostVMClass.OBJECT_TYPE));

        globals.put("forEach", voidMethod((caller, args) -> {
            Method method = (Method) args.get(0);
            for (PostVMClass item: value) {
                method.call(caller, Collections.singletonList(item));
            }
        }, CallableType.get(PostVMClass.OBJECT_TYPE, VoidClass.type)));
    }

    public String join(Caller caller, String delimiter) throws LCLangRuntimeException {
        List<String> items = new ArrayList<>();
        for(PostVMClass item: value)
            items.add(item.toString(caller));

        return String.join(delimiter, items);
    }
}
