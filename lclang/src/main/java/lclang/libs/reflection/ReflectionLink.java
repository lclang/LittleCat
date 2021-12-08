package lclang.libs.reflection;

import lclang.Link;
import lclang.libs.lang.classes.LibraryClass;
import lclang.libs.lang.classes.StringClass;
import lclang.types.Type;
import lclang.types.Types;

public class ReflectionLink extends LibraryClass {
    public static final String NAME = "ReflectionLink";
    public static final ReflectionLink INSTANCE = new ReflectionLink();
    public static final Type TYPE = INSTANCE.classType;

    public Link link;

    private ReflectionLink() {
        super(NAME);
        constructor = method((caller, lcClasses) -> new ReflectionLink(lcClasses.get(0)
                .executor.getLink(caller, lcClasses.get(1).toString(caller))), Types.ANY, StringClass.type, TYPE);
    }

    public ReflectionLink(Link value) {
        this();

        this.link = value;
        globals.put("type", method((caller, lcClasses) -> StringClass.get(value.type.toString()), StringClass.type));
        globals.put("get", method((caller, lcClasses) -> value.get.invoke(caller), Types.ANY));
        globals.put("set", voidMethod((caller, lcClasses) ->
                        value.set.invoke(caller, lcClasses.get(0)), Types.ANY));
    }
}
