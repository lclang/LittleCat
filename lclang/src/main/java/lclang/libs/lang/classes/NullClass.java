package lclang.libs.lang.classes;

import lclang.Caller;
import lclang.Value;
import lclang.exceptions.LCLangNullPointerException;
import lclang.types.Types;
import org.jetbrains.annotations.Nullable;

public class NullClass extends LibraryClass {
    public static final String name = "null";
    public static final NullClass NULL = new NullClass();

    private NullClass() {
        super(name);
    }

    @Nullable
    @Override
    public Value getLink(Caller caller, String name) throws LCLangNullPointerException {
        throw new LCLangNullPointerException(caller);
    }

    @Override
    public String toString(Caller caller) {
        return "null";
    }

    public static Types.MagicType getType() {
        return new Types.MagicType(name);
    }
}
