package lclang.libs.lang.classes;

import lclang.Caller;
import lclang.LCClass;
import lclang.exceptions.LCLangException;
import lclang.libs.lang.classes.numbers.IntClass;
import lclang.methods.Method;
import lclang.types.CallableType;
import lclang.types.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayClass extends LibraryClass {
    public static final String name = "array";
    public static final Types.MagicType type = new Types.MagicType(name);
    public static final ArrayClass instance = new ArrayClass();

    public List<LCClass> value;
    private ArrayClass() {
        super(name);
    }

    public LCClass get(int index) {
        return value.size() > index ?
                value.get(index)
                : NullClass.NULL;
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

        globals.put("add", voidMethod((caller, args) ->
                value.add(args.get(0)),
                Types.ANY).asValue());
        globals.put("size", method((caller, args) -> IntClass.get(value.size()), Types.INT).asValue());
        globals.put("last", method((caller, args) -> last(), Types.ANY).asValue());
        globals.put("remove", method((caller, args) -> BoolClass.get(list.remove(args.get(0))),
                Types.ANY, Types.BOOL).asValue());
        globals.put("removeAt", method((caller, args) -> list.remove(((IntClass) args.get(0)).value),
                Types.INT, Types.ANY).asValue());
        globals.put("join", method((caller, args) ->
                        StringClass.get(join(caller, ((StringClass) args.get(0)).string)),
                Types.STRING, Types.STRING).asValue());
        globals.put("toString", method((caller, args) ->
                        StringClass.get("["+join(caller, ", ")+"]"),
                Types.STRING).asValue());

        globals.put("filter", method((caller, args) -> {
            Method method = (Method) args.get(0);
            for (LCClass item: value) {
                if(method.call(caller, Collections.singletonList(item.asValue())).get
                        .invoke(caller).equals(BoolClass.TRUE)){
                    return item;
                }
            }

            return NullClass.NULL;
        }, CallableType.get(Types.ANY, Types.BOOL), Types.ANY).asValue());

        globals.put("forEach", voidMethod((caller, args) -> {
            Method method = (Method) args.get(0);
            for (LCClass item: value) {
                method.call(caller, Collections.singletonList(item.asValue())).get
                        .invoke(caller);
            }
        }, CallableType.get(Types.ANY, Types.VOID)).asValue());
    }

    public String join(Caller caller, String delimiter) throws LCLangException {
        List<String> items = new ArrayList<>();
        for(LCClass item: value)
            items.add(item.toString(caller));

        return String.join(delimiter, items);
    }
}
