package lclang.libs.reflection;

import lclang.Value;
import lclang.libs.lang.classes.LibraryClass;
import lclang.libs.lang.classes.StringClass;
import lclang.types.Types;

public class ReflectionValue extends LibraryClass {
    public static final String name = "ReflectionValue";
    public static final Types.MagicType type = new Types.MagicType(name);
    public static final ReflectionValue instance = new ReflectionValue();

    public Value value;

    private ReflectionValue() {
        super(name);
        constructor = method((caller, lcClasses) -> new ReflectionValue(lcClasses.get(0)
                .executor.getLink(caller, lcClasses.get(1).toString(caller))), Types.ANY, Types.STRING, type);
    }

    public ReflectionValue(Value value) {
        this();

        this.value = value;
        globals.put("type", method((caller, lcClasses) -> StringClass.get(value.type.toString()), value.type).asValue());
        globals.put("get", method((caller, lcClasses) -> value.get.invoke(caller), value.type).asValue());
        globals.put("set", voidMethod((caller, lcClasses) ->
                        value.set.invoke(caller, lcClasses.get(0).asValue()), value.type).asValue());
    }
}
