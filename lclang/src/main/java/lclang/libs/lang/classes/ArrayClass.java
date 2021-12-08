package lclang.libs.lang.classes;

import lclang.Caller;
import lclang.exceptions.LCLangRuntimeException;
import lclang.libs.lang.classes.numbers.IntClass;
import lclang.methods.Method;
import lclang.types.CallableType;
import lclang.types.Type;
import lclang.types.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayClass extends LibraryClass {
    public static final String name = "array";
    public static final ArrayClass instance = new ArrayClass();
    public static final Type type = instance.classType;

    public List<LCClass> value;
    private ArrayClass() {
        super(name);
    }

    public LCClass get(int index) {
        return value.size() > index && index >= 0 ?
                value.get(index)
                : NullClass.instance;
    }

    public void add(LCClass clazz) {
        value.add(clazz);
    }

    public LCClass last() {
        return get(value.size()-1);
    }

    public ArrayClass merge(ArrayClass array) {
        List<LCClass> items = new ArrayList<>(this.value);
        items.addAll(array.value);

        return new ArrayClass(items);
    }

    public ArrayClass(List<LCClass> list) {
        this();
        value = list;

        globals.put("add", voidMethod((caller, args) -> add(args.get(0)), Types.ANY));
        globals.put("size", method((caller, args) -> IntClass.get(value.size()), IntClass.TYPE));
        globals.put("last", method((caller, args) -> last(), Types.ANY));
        globals.put("remove", method((caller, args) -> BoolClass.get(list.remove(args.get(0))),
                Types.ANY, BoolClass.type));
        globals.put("removeAt", method((caller, args) -> list.remove(((IntClass) args.get(0)).value),
                IntClass.TYPE, Types.ANY));
        globals.put("join", method((caller, args) ->
                        StringClass.get(join(caller, ((StringClass) args.get(0)).string)),
                StringClass.type, StringClass.type));
        globals.put("toString", method((caller, args) ->
                        StringClass.get("["+join(caller, ", ")+"]"),
                StringClass.type));

        globals.put("filter", method((caller, args) -> {
            Method method = (Method) args.get(0);
            for (LCClass item: value) {
                if(method.call(caller, Collections.singletonList(item))==BoolClass.TRUE){
                    return item;
                }
            }

            return NullClass.instance;
        }, CallableType.get(Types.ANY, BoolClass.type), Types.ANY));

        globals.put("forEach", voidMethod((caller, args) -> {
            Method method = (Method) args.get(0);
            for (LCClass item: value) {
                method.call(caller, Collections.singletonList(item));
            }
        }, CallableType.get(Types.ANY, VoidClass.type)));
    }

    public String join(Caller caller, String delimiter) throws LCLangRuntimeException {
        List<String> items = new ArrayList<>();
        for(LCClass item: value)
            items.add(item.toString(caller));

        return String.join(delimiter, items);
    }
}
