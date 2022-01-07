package postvm.library.classes;

import postvm.Caller;
import postvm.Link;
import postvm.exceptions.LCLangNullPointerException;
import postvm.types.Type;

public final class NullClass extends LibraryClass {
    public static final String name = "null";
    public static final NullClass INSTANCE = new NullClass();
    public static final Type type = INSTANCE.classType;

    private NullClass() {
        super(name);
    }

    @Override
    public Link getVariableClass(Caller caller, String name) throws LCLangNullPointerException {
        throw new LCLangNullPointerException(caller);
    }

    @Override
    public String toString(Caller caller) {
        return "null";
    }
}
