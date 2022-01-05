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

    public ReflectionLink(Link link) {
        this();

        this.link = link;
    }

    @Override
    public PostVMClass loadGlobal(String target) {
        switch (target) {
            case "type": return method((caller, lcClasses) -> StringClass.get(link.get(caller)
                    .classType.toString()), StringClass.type);
            case "get": return method((caller, lcClasses) -> link.get(caller), PostVMClass.OBJECT_TYPE);
            case "set": return voidMethod((caller, lcClasses) ->
                    link.set(caller, lcClasses.get(0)), PostVMClass.OBJECT_TYPE);
        }

        return super.loadGlobal(target);
    }
}
