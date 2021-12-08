package lclang.libs.reflection;

import lclang.Link;
import lclang.libs.lang.classes.LibraryClass;
import lclang.libs.lang.classes.StringClass;
import lclang.types.Type;
import lclang.types.Types;

public class ReflectionValue extends LibraryClass {
    public static final String NAME = "ReflectionValue";
    public static final ReflectionValue INSTANCE = new ReflectionValue();
    public static final Type TYPE = INSTANCE.classType;

    public Link value;

    private ReflectionValue() {
        super(NAME);
        constructor = method((caller, lcClasses) -> new ReflectionValue(lcClasses.get(0)
                .executor.getLink(caller, lcClasses.get(1).toString(caller))), Types.ANY, StringClass.type, TYPE);
    }

    public ReflectionValue(Link value) {
        this();

        this.value = value;
        globals.put("type", method((caller, lcClasses) -> StringClass.get(value.type.toString()), StringClass.type));
        globals.put("get", method((caller, lcClasses) -> value.get.invoke(caller), Types.ANY));
        globals.put("set", voidMethod((caller, lcClasses) ->
                        value.set.invoke(caller, lcClasses.get(0)), Types.ANY));
    }
}
