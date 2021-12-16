package postvm.reflection;

import postvm.Link;
import postvm.library.classes.LibraryClass;
import postvm.library.classes.PostVMClass;
import postvm.library.classes.StringClass;
import postvm.types.Type;

public class ReflectionLink extends LibraryClass {
    public static final String NAME = "ReflectionLink";
    public static final ReflectionLink INSTANCE = new ReflectionLink();
    public static final Type TYPE = INSTANCE.classType;

    public Link link;

    private ReflectionLink() {
        super(NAME);
        constructor = method((caller, lcClasses) -> new ReflectionLink(lcClasses.get(0)
                .executor.getLink(lcClasses.get(1).toString(caller))), PostVMClass.OBJECT_TYPE, StringClass.type, TYPE);
    }

    public ReflectionLink(Link value) {
        this();

        this.link = value;
        globals.put("type", method((caller, lcClasses) -> StringClass.get(value.get(caller)
                .classType.toString()), StringClass.type));
        globals.put("get", method((caller, lcClasses) -> value.get(caller), PostVMClass.OBJECT_TYPE));
        globals.put("set", voidMethod((caller, lcClasses) ->
                        value.set(caller, lcClasses.get(0)), PostVMClass.OBJECT_TYPE));
    }
}
