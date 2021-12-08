package lclang.libs.lang.classes;

import lclang.Caller;
import lclang.Value;
import lclang.exceptions.LCLangRuntimeException;
import lclang.exceptions.LCLangTypeErrorException;
import lclang.types.Type;

public class VoidClass extends LibraryClass {
    public static final String name = "void";
    public static final VoidClass instance = new VoidClass();
    public static final Type type = instance.classType;
    public static final Value value = instance.asValue();

    private VoidClass() {
        super(name);
    }

    @Override
    public Value getLink(Caller caller, String name) throws LCLangRuntimeException {
        throw new LCLangTypeErrorException("void", caller);
    }

    @Override
    public String toString(Caller caller) throws LCLangRuntimeException {
        return "void";
    }
}
