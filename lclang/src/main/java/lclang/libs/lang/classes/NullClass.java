package lclang.libs.lang.classes;

import lclang.Caller;
import lclang.Link;
import lclang.exceptions.LCLangNullPointerException;
import lclang.types.Type;

public class NullClass extends LibraryClass {
    public static final String name = "null";
    public static final NullClass instance = new NullClass();
    public static final Type type = instance.classType;

    private NullClass() {
        super(name);
    }

    @Override
    public Link getLink(Caller caller, String name) throws LCLangNullPointerException {
        throw new LCLangNullPointerException(caller);
    }

    @Override
    public String toString(Caller caller) {
        return "null";
    }
}
