package lclang.libs.lang.classes;

import lclang.Caller;
import lclang.Value;
import lclang.exceptions.LCLangNullPointerException;
import lclang.types.Types;

public class NullClass extends LibraryClass {
    public static final String name = "null";
    public static final Types.MagicType type = new Types.MagicType(name);
    public static final NullClass instance = new NullClass();

    private NullClass() {
        super(name);
    }

    @Override
    public Value getLink(Caller caller, String name) throws LCLangNullPointerException {
        throw new LCLangNullPointerException(caller);
    }

    @Override
    public String toString(Caller caller) {
        return "null";
    }
}
