package postvm.library.classes;

import postvm.Caller;
import postvm.exceptions.LCLangNullPointerException;
import postvm.types.Type;

public class NullClass extends LibraryClass {
    public static final String name = "null";
    public static final NullClass instance = new NullClass();
    public static final Type type = instance.classType;

    private NullClass() {
        super(name);
    }

    @Override
    public PostVMClass getVariableClass(Caller caller, String name) throws LCLangNullPointerException {
        throw new LCLangNullPointerException(caller);
    }

    @Override
    public String toString(Caller caller) {
        return "null";
    }
}
