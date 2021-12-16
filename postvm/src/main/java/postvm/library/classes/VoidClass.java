package postvm.library.classes;

import postvm.Caller;
import postvm.Link;
import postvm.exceptions.LCLangRuntimeException;
import postvm.exceptions.LCLangTypeErrorException;
import postvm.types.Type;

public class VoidClass extends LibraryClass {
    public static final String name = "void";
    public static final VoidClass instance = new VoidClass();
    public static final Type type = instance.classType;
    public static final Link value = instance.createLink();

    private VoidClass() {
        super(name);
    }

    @Override
    public PostVMClass getVariableClass(Caller caller, String name) throws LCLangRuntimeException {
        throw new LCLangTypeErrorException("void", caller);
    }

    @Override
    public String toString(Caller caller) throws LCLangRuntimeException {
        return "void";
    }
}
