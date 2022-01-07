package postvm.library.classes;

import postvm.Caller;
import postvm.Link;
import postvm.exceptions.LCLangRuntimeException;
import postvm.exceptions.LCLangTypeErrorException;
import postvm.types.Type;

public final class VoidClass extends LibraryClass {
    public static final String name = "void";
    public static final VoidClass INSTANCE = new VoidClass();
    public static final Type type = INSTANCE.classType;
    public static final Link value = INSTANCE.createLink();

    private VoidClass() {
        super(name);
    }

    @Override
    public Link getVariableClass(Caller caller, String name) throws LCLangRuntimeException {
        throw new LCLangTypeErrorException("Class is void", caller);
    }

    @Override
    public String toString(Caller caller) throws LCLangRuntimeException {
        return "void";
    }
}
